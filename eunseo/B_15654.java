import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: N과 M (5)
 * 메모리: 61252 kb
 * 시간: 1148 ms
 * 풀이: 중복을 포함하지 않는 순열 활용
 */
public class B_15654 {
    static int[] numbers;
    static int[] save;
    static int N, M;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        save = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        perm(0);
    }

    private static void perm(int cnt) {
        if(cnt == M) {
            sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                sb.append(save[i]).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            save[cnt] = numbers[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
