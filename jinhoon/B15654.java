package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: N과 M (B15654)
 * 풀이: dfs + 백트래킹
 * 메모리: 37992kb
 * 시간: 388ms
 */
public class B15654 {

    int N, M;
    int[] arr;
    boolean[] isVisited;
    StringBuilder result;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs("", 0);

        System.out.println(result);
    }

    private void dfs(String num, int count) {

        if (count == M) {
            result.append(num).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(num + arr[i] + " ", count + 1);
                isVisited[i] = false;
            }
        }

    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B15654().solution();
//    }
//}
