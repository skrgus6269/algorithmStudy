package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 징검다리건너기 (B22871)
 * 풀이: 이분탐색
 * 메모리: 19156kb
 * 시간: 792ms
 */
public class B22871 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] stone = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        long low = 1;
        long high = (long) (N - 1) * (1 + Math.abs(stone[0] - stone[N - 1])); // 시작점에서 끝점까지 바로 가는 경우
        long answer = high;

        boolean[] visit;
        while (low <= high) {
            long mid = (low + high) / 2;

            // K = mid (최대힘이 mid) 일 때 다리를 건너갈 수 있는지 확인한다.
            visit = new boolean[N]; // true 이면 갈 수 있다.
            visit[0] = true; // 시작점 세팅

            // 1번돌부터 N번돌까지 확인한다.
            for (int i = 1; i < N; i++) {
                // i번돌까지 갈 수 있는지 확인한다.
                for (int j = 0; j < i; j++) {

                    // i번 돌에 mid 힘 이하로 도달 할 수 있다면 i번 돌을 갈 수 있는 돌이고 반복문 탈출
                    if(visit[j] && (long) (i - j) * (1 + Math.abs(stone[i] - stone[j])) <= mid) {
                        visit[i] = true;
                        break;
                    }
                }
            }

            // 마지막 지점이 true 라면 다리를 건넜다는 뜻이므로 더 작은 K 가 있는지 찾아준다.
            if (visit[N - 1]) {
                answer = mid;
                high = mid - 1;
            } else {
                // 다리를 못건넜다면 더 큰 K 값을 통해 찾아준다.
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B22871().solution();
//    }
//}
