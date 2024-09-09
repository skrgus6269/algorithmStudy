package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 입국 심사 (B3079)
 * 풀이: 이분탐색
 * 메모리: 23780kb
 * 시간: 284ms
 */
public class B3079 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] judge = new int[N];
        long max = -1;
        for (int i = 0; i < N; i++) {
            judge[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, judge[i]);
        }

        long low = 1;
        long high = M * max;
        long result = high;

        while (low <= high) {

            long mid = (low + high) / 2;

            long sum = 0; // mid 시간 내에 통과할 수 있는 최대 인원수
            for (int n : judge) {
                sum += mid / n;
                // 최악의 경우 T=1 N=100_000 mid=10^18/2 => sum 이 오버플로우가 발생하므로 sum 이 M을 넘기는 순간 반복문 탈출
                if (sum > M) {
                    break;
                }
            }

            // 최대 통과 인원이 주어진 인원 보다 많다면
            if (sum >= M) {
                // 최소시간 업데이트
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                // 최대 통과 인원이 주어진 인원 보다 적다면
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B3079().solution();
//    }
//}
