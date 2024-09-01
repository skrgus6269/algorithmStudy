import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    BOJ 3079
    java 11 / 29028 KB / 416 ms
 */
public class Main {

    static int N;
    static long M;
    static long[] times;
    static long maxTime = Long.MIN_VALUE;
    static long result = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        times = new long[N];

        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        Arrays.sort(times);

        long low = 0;
        long high = M * maxTime;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (long time : times) {
                long count = mid / time;

                if (M <= sum) {
                    break;
                }
                sum += count;
            }
            if (M <= sum) {
                high = mid - 1;
                result = Math.min(mid, result);
            } else {
                low = mid + 1;
            }
        }

        System.out.print(result);
    }
}
