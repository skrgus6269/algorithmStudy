import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 색종이 만들기
 * 메모리: 13140 kb
 * 시간: 104 ms
 * 풀이: 재귀와 분할 정복 사용
 */
public class B_2630 {
    static int[][] graph;
    static int blue, white;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        blue = 0;
        white = 0;

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void cut(int row, int col, int size) {
        int sum = 0;
        for(int i = row; i < row+size; i++) {
            for(int j = col; j < col+size; j++) {
                if(graph[i][j] == 1) {
                    sum++;
                    continue;
                }
            }
        }

        if(sum == (size*size)) {
            blue++;
            return;
        }

        if(sum == 0) {
            white++;
            return;
        }

        cut(row, col, size/2);
        cut(row, col+size/2, size/2);
        cut(row+size/2, col, size/2);
        cut(row+size/2, col+size/2, size/2);
    }
}
