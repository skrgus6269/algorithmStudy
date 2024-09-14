import java.io.*;
import java.util.*;

/**
 * 문제: 톱니바퀴
 * 메모리: 11832 kb
 * 시간: 68 ms
 * 풀이: 구현
 */
public class B_14891 {
    static List<Integer>[] arr;
    static int[] dirArr;    // 회전 방향 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new ArrayList[5];

        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            arr[i] = new ArrayList<>();

            for (int j = 0; j < 8; j++) {
                arr[i].add(str.charAt(j) - '0');
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            dirArr = new int[5];
            dirArr[num] = dir;

            // 왼쪽 톱니바퀴들 처리
            for (int j = num - 1; j >= 1; j--) {
                if (arr[j].get(2) == arr[j + 1].get(6)) continue;

                dirArr[j] = -dirArr[j + 1];
            }

            // 오른쪽 톱니바퀴들 처리
            for (int j = num + 1; j <= 4; j++) {
                if (arr[j].get(6) == arr[j - 1].get(2)) continue;

                dirArr[j] = -dirArr[j - 1];
            }

            // 각 톱니바퀴 회전
            for (int j = 1; j <= 4; j++) {
                if (dirArr[j] == 1) {
                    // 시계 방향 회전
                    arr[j].add(0, arr[j].remove(7));
                } else if (dirArr[j] == -1) {
                    // 반시계 방향 회전
                    arr[j].add(arr[j].remove(0));
                }
            }
        }

        int result = 0;
        int score = 1;
        for (int i = 1; i <= 4; i++) {
            if (arr[i].get(0) == 1) {
                result += score;
            }
            score *= 2;
        }

        System.out.println(result);
    }
}
