package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제: (B5430)
 * 풀이: 덱(deck)
 * 메모리: 99836kb
 * 시간: 848ms
 */
public class B5430 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String[] numbers = br.readLine().replaceAll("\\[|\\]", "").split(",");
            Deque<Integer> deck = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                deck.addLast(Integer.parseInt(numbers[i]));
            }

            // isReversed 가 false 면 뒤집히지 않은 상태
            boolean isReversed = false;
            boolean isError = false;
            for (int i = 0; i < commands.length; i++) {
                int cur = commands[i];

                if (cur == 'R') {
                    isReversed = !isReversed;
                }

                if (cur == 'D') {

                    if (deck.isEmpty()) {
                        // 비어있으면 error
                        result.append("error").append("\n");
                        isError = true;
                        break;
                    }

                    if (isReversed) {
                        // 뒤집힌 상태라면 뒤에서 버림
                        deck.pollLast();
                    } else {
                        // 정방향이면 앞으로 버림
                        deck.pollFirst();
                    }
                }
            }

            if (isError) {
                continue;
            }

            // 명령어가 끝나고 덱에 남은것을 출력
            result.append("[");
            while (!deck.isEmpty()) {
                if (isReversed) {
                    // 뒤집힌 상태라면 뒤에서 버림
                    result.append(deck.pollLast());
                } else {
                    // 정방향이면 앞으로 버림
                    result.append(deck.pollFirst());
                }

                if (!deck.isEmpty()) {
                    result.append(",");
                }
            }

            result.append("]\n");

        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B5430().solution();
//    }
//}
