import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    BOJ 2096 내려가기
    java 11 / 41976 KB / 380 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N;
        int[] min = new int[3];
        int[] max = new int[3];
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x0 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                min[0] = max[0] = x0;
                min[1] = max[1] = x1;
                min[2] = max[2] = x2;
                continue;
            }

            int tempMax0 = max[0];
            int tempMax2 = max[2];

            max[0] = Math.max(max[0], max[1]) + x0;
            max[2] = Math.max(max[1], max[2]) + x2;
            max[1] = Math.max(Math.max(tempMax0, tempMax2), max[1]) + x1;

            int tempMin0 = min[0];
            int tempMin2 = min[2];

            min[0] = Math.min(min[0], min[1]) + x0;
            min[2] = Math.min(min[1], min[2]) + x2;
            min[1] = Math.min(Math.min(tempMin0, tempMin2), min[1]) + x1;
        }

        System.out.print(String.format("%d %d", Math.max(Math.max(max[0], max[1]), max[2]), Math.min(Math.min(min[0], min[1]), min[2])));
    }
}

