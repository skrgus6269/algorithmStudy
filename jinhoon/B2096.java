package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 내려가기 (B2096)
 * 풀이: 메모리 절약을 위해 이전 라인 저장배열과, 현재 라인 저장배열을 이용해 dp 계산
 * 메모리: 44772kb
 * 시간: 436ms
 */
public class B2096 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] maxpre = new int[5];
        int[] minpre = new int[5];
        int[] maxcur = new int[5];
        int[] mincur = new int[5];

        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= 3; j++) {
            int num = Integer.parseInt(st.nextToken());
            maxpre[j] = num;
            minpre[j] = num;
            maxcur[j] = num;
            mincur[j] = num;
        }
        minpre[0] = Integer.MAX_VALUE;
        minpre[4] = Integer.MAX_VALUE;

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 3; j++) {
                int num = Integer.parseInt(st.nextToken());

                maxcur[j] = Math.max(num + maxpre[j], Math.max(maxpre[j - 1], maxpre[j + 1]) + num);
                mincur[j] = Math.min(num + minpre[j], Math.min(minpre[j - 1], minpre[j + 1]) + num);
            }
            mincur[0] = Integer.MAX_VALUE;
            mincur[4] = Integer.MAX_VALUE;
            System.arraycopy(maxcur, 0, maxpre, 0, 5);
            System.arraycopy(mincur, 0, minpre, 0, 5);
        }


        int maxR = maxcur[1];
        int minR = mincur[1];
        for (int j = 2; j <= 3; j++) {
            maxR = Math.max(maxR, maxcur[j]);
            minR = Math.min(minR, mincur[j]);
        }

        System.out.println(maxR + " " + minR);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2096().solution();
//    }
//}
