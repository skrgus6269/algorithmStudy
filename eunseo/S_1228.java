import java.io.*;
import java.util.*;

/**
 * 문제: 암호문1
 * 메모리: 28,428 kb
 * 시간: 108 ms
 * 풀이: (구현)리스트 사용
 */
public class S_1228 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> arr;
        StringBuilder sb;

        for(int t = 1; t <= 10; t++) {
            arr = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            int S = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < S; i++) {
                st.nextToken();
                int loc = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                for(int j = 0; j < len; j++) {
                    arr.add(loc, Integer.parseInt(st.nextToken()));
                    loc++;
                }
            }

            System.out.print("#" + t + " ");

            sb = new StringBuilder();
            for(int i = 0; i < 10; i++) {
                sb.append(arr.get(i)).append(" ");
            }

            System.out.println(sb);
        }
    }
}
