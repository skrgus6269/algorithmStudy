package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: 택배 (B8980)
 * 풀이: 그리디
 * 메모리: 21036kb
 * 시간: 308ms
 */
public class B8980 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        Box[] boxes = new Box[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());

            boxes[i] = new Box(start, end, box);
        }

        Arrays.sort(boxes, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int[] maxAmount = new int[N + 1];
        Arrays.fill(maxAmount, C);

        int result = 0;
        for (Box box : boxes) {
            int maxBoxNum = Integer.MAX_VALUE;

            for (int i = box.start; i < box.end; i++) {
                maxBoxNum = Math.min(maxBoxNum, maxAmount[i]);
            }

            if (maxBoxNum >= box.num) {
                for (int i = box.start; i < box.end; i++) {
                    maxAmount[i] -= box.num;
                }
                result += box.num;
            } else {
                for (int i = box.start; i < box.end; i++) {
                    maxAmount[i] -= maxBoxNum;
                }
                result += maxBoxNum;
            }
        }


        System.out.println(result);
    }

    static class Box {
        int start;
        int end;
        int num;

        public Box(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B8980().solution();
//    }
//}
