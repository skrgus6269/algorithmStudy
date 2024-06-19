package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 도영이가 만든 맛있는 음식
 * 풀이: 완전탐색(DFS)
 * 메모리: 14192kb
 * 시간: 108ms
 */
public class B2961 {

    int n;
    int[] s;
    int[] b;
    int answer = Integer.MAX_VALUE;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        s = new int[n];
        b = new int[n];

        for (int test = 0; test < n; test++) {
            st = new StringTokenizer(br.readLine());
            s[test] = Integer.parseInt(st.nextToken());
            b[test] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0);

        System.out.println(answer);
    }

    private void dfs(int depth, int sMul, int bSum) {
        if (depth == n) {
            if (bSum > 0) { // 재료를 1개 이상 선택
                answer = Math.min(answer, Math.abs(sMul - bSum));
            }
            return;
        }

        dfs(depth + 1, sMul * s[depth], bSum + b[depth]); // 재료 선택
        dfs(depth + 1, sMul, bSum); // 재료 미선택
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2961().solution();
//    }
//}
