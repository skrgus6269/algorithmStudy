import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제: 쿼드트리
 * 메모리: 11668 kb
 * 시간: 80 ms
 * 풀이: 백준 '색종이 만들기'와 유사, 재귀와 분할정복 사용, 재귀 사용 순서 고려 + 괄호 고려
 */
public class B_1992 {
    static int[][] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        cut(0, 0, N);

        System.out.println(sb);
    }

    private static void cut(int row, int col, int size) {
        int sum = 0;
        for(int i = row; i < row+size; i++) {
            for(int j = col; j < col+size; j++) {
                if(graph[i][j] == 1) {
                    sum++;
                }
            }
        }

        if(sum == (size*size)) {
            sb.append(1);
            return;
        }

        if(sum == 0) {
            sb.append(0);
            return;
        }

        sb.append("(");
        cut(row, col, size/2);
        cut(row, col+size/2, size/2);
        cut(row+size/2, col, size/2);
        cut(row+size/2, col+size/2, size/2);
        sb.append(")");
    }
}
