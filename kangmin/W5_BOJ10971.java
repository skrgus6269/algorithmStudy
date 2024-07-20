import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    BOJ 10971 외판원 순회2
    java 11 / 14592 KB / 148 ms
 */
public class Main {

    static int N;
    static int [][] cost;
    static boolean[] visited;
    static int result  = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i<N; i++) {
            visited[i] = true;
            dfs(i, i, 1, 0);
        }

        System.out.print(result);
    }

    public static void dfs(int start, int current, int depth, int sum) {
        if (depth == N) {
            if (cost[current][start] != 0) {
                sum += cost[current][start];
                result = Math.min(result, sum);
            }

            return;
        }

        for (int i = 0; i<N; i++) {
            if (visited[i]) {
                continue;
            }

            if (cost[current][i] == 0) {
                continue;
            }

            visited[i] = true;
            dfs(start, i, depth+1, sum +  cost[current][i]);
            visited[i] = false;
        }
    }
}

