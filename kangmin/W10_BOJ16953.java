import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    BOJ 16953
    java 11 / 14152 KB / 100 ms
 */
public class Main {

    static int A, B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dfs(A, 1);
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);
    }

    public static void dfs(long num, int cnt) {
        if (num == B) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (num * 2 <= B) {
            dfs(num * 2, cnt + 1);
        }
        if (num * 10 + 1 <= B) {
            dfs(num * 10 + 1, cnt + 1);
        }
    }
}
