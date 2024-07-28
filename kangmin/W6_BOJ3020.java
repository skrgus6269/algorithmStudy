import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    java 11 / 30984 KB /  308 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, H;
        int[] up, down;

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        up = new int[H + 2];
        down = new int[H + 2];

        /*
            높이별로 석순, 종유석 개수 저장
         */
        for (int i = 1; i <= N / 2; i++) {
            int downHeight = Integer.parseInt(br.readLine());
            int upHeight = H - Integer.parseInt(br.readLine()) + 1;

            down[downHeight]++;
            up[upHeight]++;
        }

        /*
            높이별 지나가는 장애물 개수
         */
        for (int i = 1; i <= H; i++) {
            down[i] += down[i - 1];
        }

        for (int i = H; 0 < i; i--) {
            up[i] += up[i + 1];
        }

        int min = N;
        int count = 1;

        /*
            i 구간을 통과할 때 down[i-1] & up[i+1] 은 부딪히지 않고 통과 가능
         */
        for (int i = 1; i <= H; i++) {
            int conflict = (down[H] - down[i - 1]) + (up[1] - up[i + 1]);

            if (conflict < min) {
                min = conflict;
                count = 1;
            } else if (conflict == min) {
                count++;
            }
        }

        System.out.print(String.format("%d %d", min, count));

    }
}

