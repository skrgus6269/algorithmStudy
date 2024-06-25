package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제: 암호문1(S1228)
 * 풀이 : LinkedList 이용, 데이터 중간에 삽입하는 경우 ArrayList 보다 뛰어난 성능을 가짐
 * 메모리: 19,692kb
 * 시간: 120ms
 */
public class S1228 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        for (int test = 1; test <= 10; test++) {

            List<String> numbers = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if(st.nextToken().equals("I")) { // 명령(I)
                    int x = Integer.parseInt(st.nextToken()); // x
                    int y = Integer.parseInt(st.nextToken()); // y
                    List<String> s = new LinkedList<>(); // s
                    for (int j = 0; j < y; j++) {
                        s.add(st.nextToken());
                    }
                    numbers.addAll(x, s);
                }
            }

            result.append("#").append(test).append(" ");
            for (int i = 0; i < 10; i++) {
                result.append(numbers.get(i)).append(" ");
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}

