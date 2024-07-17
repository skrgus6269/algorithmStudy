package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 외판원 문제2 (B10971)
 * 풀이: dfs + 백트래킹
 * 1. 어떤 도시에서 출발하든 결과값은 같다.
 * 2. 1번도시에서 출발하여 DFS+백트래킹으로 완전탐색한다.
 * 3. 도시수 - 1 만큼 탐색했다면, 마지막길에서 1번도시로 가는 비용을 더해 최종계산 한다.
 * 메모리: 14524kb
 * 시간: 152ms
 */
public class B10971 {

    int N;
    int[][] cost;
    boolean[] isVisited;
    int result = Integer.MAX_VALUE;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1부터 시작, 어디서든 출발하든 결과는 같기에 한번만 한다.
        isVisited[1] = true;
        dfs(1, 0, 0);

        System.out.println(result);
    }

    private void dfs(int start, int value, int count) {

        if (count == N - 1) {
            // N-1 에서 멈춰서 마지막 출발길로 가는값은 여기서 더함
            if (cost[start][1] != 0) {
                result = Math.min(result, value + cost[start][1]);
            }
            return;
        }

        for (int i = 2; i <= N; i++) {
            if (!isVisited[i] && cost[start][i] != 0) {
                isVisited[i] = true;
                dfs(i, value + cost[start][i], count + 1);
                isVisited[i] = false;
            }

        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B10971().solution();
//    }
//}
