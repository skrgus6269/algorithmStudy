package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 개똥벌레 (B3020)
 * 풀이: 누적합
 * 1. 아래서 자란 장애물과 위에서 자란 장애물 길이에 대하 저장합니다.
 * 2. 아래서 자란 장매물과 위에서 자란 장애물에 대한 누적합을 구합니다.(누적합을 구할때 해당 장애물 개수가 거꾸로 구해지는걸 주의합니다)
 * 3. 아래서 자란 장애물과 위에서 자란 장애물을 합치고, 최소가 되는 충돌을 구합니다.
 * 메모리: 30656kb
 * 시간: 344ms
 */
public class B3020 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int minObs = Integer.MAX_VALUE;
        int[] down = new int[H + 2];
        int[] up = new int[H + 2];
        for (int i = 1; i <= N; i++) {
            int length = Integer.parseInt(br.readLine());

            if (i % 2 == 1) {
                // 아래 자란 장애물
                down[length]++;
            } else {
                // 위에서 자란 장애물
                up[H - length + 1]++;
            }
        }

        // 누적합
        // 아래서 자란 장애물에 대한 누적합
        for (int i = 1; i <= H; i++) {
            // 거꾸로 쌓여있음
            down[i] += down[i - 1];
        }
        // 위에서 자란 장애물에 대한 누적합
        for (int i = H; i >= 1; i--) {
            // 거꾸로 쌓여있음
            up[i] += up[i + 1];
        }

        int count = 0;
        for(int i =1; i<=H; i++) {
            int obs = down[H] - down[i - 1] + up[1] - up[i + 1];

            if (obs < minObs) {
                minObs = obs;
                count = 1;
            } else if (obs == minObs) {
                count++;
            }
        }

        System.out.println(minObs + " " + count);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B3020().solution();
//    }
//}
