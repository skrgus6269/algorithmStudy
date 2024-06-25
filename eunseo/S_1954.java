import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 달팽이 숫자
 * java8 / 24,964 kb / 197 ms /
 *
 * 가로에서 세로로 넘어갈 때 N값을 1씩 줄이고
 * 세로에서 가로로 넘어갈 때 더해주는 방향을 바꿔준다
 */
public class 달팽이숫자 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] snail = new int[N][N];

            int count = 1;

            int d = 1;  // 방향
            int r = 0;  // 가로
            int c = -1;  // 세로

            while(N > 0) {

                // 가로 방향 이동
                for(int i = 0; i < N; i++) {
                    c += d;
                    snail[r][c] = count;
                    count++;
                }

                N--;

                // 세로 방향 이동
                for(int i = 0; i < N; i++) {
                    r += d;
                    snail[r][c] = count;
                    count++;
                }

                d *= -1;
            }

            System.out.println("#" + t);
            for(int[] row : snail) {
                for(int s : row) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
    }
}
