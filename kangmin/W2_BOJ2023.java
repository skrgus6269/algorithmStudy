import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 java 11 / 14304 KB / 120 ms
 */
public class Main {

    static int n = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        System.out.print(sb.toString());
    }

    public static void dfs(int length, int num) {
        if (length == n) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 0; i < 10; i++) {
            int nextNum = num * 10 + i;
            if (isPrime(nextNum)) {
                dfs(length + 1, nextNum);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
