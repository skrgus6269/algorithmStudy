import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분집합을 사용해서 모든 재료 조합을 구함
 * 부분집합은 비트마스크를 사용해서 구현함
 */
public class Main {
    static int[][] food;
    static int N, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        food = new int[N][2];
        result = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }

        subset();

        System.out.println(result);
    }

    private static void subset() {
        int combS, combB;
        for(int i = 1; i < (1<<N); i++) {
            combS = 1;
            combB = 0;
            for(int j = 0; j < N; j++) {
                if((i&(1<<j)) == 0) continue;

                combS *= food[j][0];
                combB += food[j][1];
            }

            result = Math.min(result, Math.abs(combS - combB));
        }
    }
}
