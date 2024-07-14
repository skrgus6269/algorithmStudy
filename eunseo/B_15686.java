import java.io.*;
import java.util.*;

/**
 * 문제: 치킨배달
 * 메모리: 12312 kb
 * 시간: 128 ms
 * 풀이: 조합으로 치킨집울 선정함
 */
public class B_15686 {
    static int N, M, result;
    static int[][] arr;
    static List<int[]> chick;
    static int[] input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chick = new ArrayList<>();
        arr = new int[N][N];
        input = new int[M];
        result = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    chick.add(new int[] {i, j});
                }
            }
        }

        comb(0, 0);

        System.out.println(result);
    }

    static private void comb(int cnt, int start) {
        if(cnt == M) {
            result = Math.min(calculate(), result);
            return;
        }

        for(int i = start; i < chick.size(); i++) {
            input[cnt] = i;
            comb(cnt+1, i+1);
        }
    }

    static private int calculate() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                    for(int k = 0; k < M; k++) {
                        int chickX = chick.get(input[k])[0];
                        int chickY = chick.get(input[k])[1];

                        min = Math.min(Math.abs(i-chickX) + Math.abs(j-chickY), min);
                    }

                    sum += min;
                }
            }
        }
        return sum;
    }
}
