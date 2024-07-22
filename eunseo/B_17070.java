import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 파이프 옮기기 1
 * 메모리: 16656 kb
 * 시간: 192 ms
 * 풀이: dfs 사용
 */
public class B_17070 {
    static int[][] graph;
    static int N, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(result);
    }

    // state: 0-가로 , 1-세로, 2-대각
    static void dfs(int x, int y, int state) {
        if (x == N-1 && y == N-1) {
            result++;
            return;
        }

        if(state == 0){ // 파이프가 가로인 경우
            if(y+1 < N && graph[x][y+1] == 0){
                dfs(x, y + 1, 0);   // 가로(오른쪽)로 갈 수 있음
            }
        } else if(state == 1){  // 파이프가 세로인 경우
            if(x+1 < N && graph[x+1][y] == 0){
                dfs(x+1, y, 1);     // 세로(아래)로 갈 수 있음
            }
        } else{ // 파이프가 대각인 경우
            if(y+1 < N && graph[x][y+1] == 0){
                dfs(x, y + 1, 0);   // 가로(오른쪽)로 갈 수 있고
            }
            if(x+1 < N && graph[x+1][y] == 0){
                dfs(x+1, y , 1);    // 세로(아래)도 갈 수 있음
            }
        }

        // 파이프가 가로인 경우, 세로인 경우, 대각인 경우 모두 대각으로 갈 수 있음
        if (x+1 < N && y+1 < N && graph[x][y+1] == 0 && graph[x+1][y] == 0 && graph[x + 1][y + 1] == 0) { // graph 범위 안나가고, 벽이 아닌지 체크
            dfs(x + 1, y + 1, 2);   // 대각은 파이프가
        }

    }
}
