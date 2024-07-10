package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (B1074)
 * 풀이: 구현-분할정복
 * 추가 설명: 사분면나누기 -> 좌표가 속하는 사분면 구함 -> 사분면에 따른 값 더함 -> 좌표 값 수정 -> 반복
 * 메모리: 14252kb
 * 시간: 108ms
 */
public class B1074 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        while (N != 0) {
            N--;

            long box = (int) Math.pow(2, N);
            // 2사분면, 1사분면은 빼줄값이 없어서 적을필요 없음.
            if (r < box && c >= box) {
                result += box * box;
                c -= box;
            } else if (r >= box && c < box) {
                // 3사분면
                result += box * box * 2;
                r -= box;
            } else if (r >= box && c >= box) {
                // 4사분면
                result += box * box * 3;
                r -= box;
                c -= box;
            }
        }


        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1074().solution();
//    }
//}
