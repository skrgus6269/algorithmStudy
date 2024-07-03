import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 미세먼지 안녕
 * 메모리: 26064 kb
 * 시간: 220 ms
 * 풀이: 공기청정기 움직임 상하좌우 메서드 분리,
 *      다음 초 계산할 때 전에 구한 결과(plus) 얕은 복사로 옮기고(graph로) 다시 새로 초기화해서 구함
 */
public class B_17144 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] plus, graph;
    static int R, C, T, machine;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == -1) {
                    machine = i;
                }
            }
        }


        for(int t = 0; t < T; t++) {
            if (t >= 1) {
                graph = plus;
            }
            plus = new int[R][C];
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {

                    if(graph[i][j] > 0) {
                        int temp = graph[i][j]/5;
                        int count = 0;
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx < 0 || ny < 0 || nx >= R || ny >= C || graph[nx][ny] == -1) continue;

                            count++;

                            plus[nx][ny] += temp;
                        }

                        plus[i][j] += (graph[i][j] - (temp*count));
                    }
                }
            }


            cleanUp(machine-1);
            cleanDown(machine);
        }

        int result = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                result += plus[i][j];
            }
        }

        System.out.println(result+2);
    }

    static private void cleanUp(int check) {
        goDown(check,0, 0);
        goBack(0);
        goUp(0, check, C-1);
        goFront(check);

        plus[check][0] = -1;
    }

    static private void cleanDown(int check) {
        goUp(check, R-1, 0);
        goBack(R-1);
        goDown(R-1, check, C-1);
        goFront(check);

        plus[check][0] = -1;
    }

    static private int goFront(int row) {
        int pre = 0;
        int temp = 0;
        for(int i = 1; i < C; i++) {
            temp = plus[row][i];
            plus[row][i] = pre;
            pre = temp;
        }
        return temp;
    }

    static private void goUp(int start, int end, int col) {
        for(int i = start; i < end; i++) {
            plus[i][col] = plus[i+1][col];
        }
    }

    static private void goBack(int row) {
        for(int i = 0; i < C-1; i++) {
            plus[row][i] = plus[row][i+1];
        }
    }

    static private void goDown(int start, int end, int col) {
        for(int i = start; i > end; i--) {
            plus[i][col] = plus[i-1][col];
        }
    }
}
