package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제: 문자열 폭발 (B9935)
 * 풀이: 스발
 * 메모리: 35760kb
 * 시간: 420ms
 */
public class B9935 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        int bSize = bomb.length;

        Stack<Character> stack = new Stack<>();

        for (char value : str) {
            stack.push(value);

            if (stack.size() >= bSize) {
                boolean isBomb = true;

                for (int j = 0; j < bSize; j++) {
                    if (stack.get(stack.size() - bSize + j) != bomb[j]) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < bSize; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        for (char c : stack) {
            result.append(c);
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B9935().solution();
//    }
//}
