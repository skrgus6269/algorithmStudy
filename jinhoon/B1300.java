package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: k번째 수 (B1300)
 * 풀이: 이분탐색
 * 메모리: 14196kb
 * 시간: 144ms
 */
public class B1300 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        long low = 1;
        long high = k;

        // 오름차순으로 정렬된 B[k] 에서 k의 의미는
        // k 만큼 작은 수가 존재한다는 뜻이다.
        // 이를 이용해 이분탐색으로 B[k] 를 찾는다.
        // lower-bound (찾고자 하는 값 이상이 처음 나타나는 위치를 찾는다)
        while (low < high) {

            long mid = (low + high) / 2;

            long sum = 0; // B[x] = mid 일 때 x 값
            // 2차원 배열에서 x 값 이하는
            // 각 행을 나눠준 값들의 합이다.
            for (int i = 1; i <= N; i++) {
                sum += Math.min(mid / i, N); // 최대크기는 N 이므로 N을 넘어가면 N을 선택한다.
                if (sum > k) {
                    break;
                }
            }

            // sum 이 k 보다 크다면 값을 더 작게 조정
            if (sum >= k) {
                high = mid;
            } else {
                // sum 이 k 보다 작다면 값을 더 크게 조정
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1300().solution();
//    }
//}
