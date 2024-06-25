package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 신기한 소수(B2023)
 * 1차 : 에라토스테네스의 체(메모리 초과)
 * 2차 : DFS + 백트래킹(소수의 특징을 이용)
 * 메모리: 14160kb
 * 시간: 124ms
 */
public class B2023 {

    int[] startNum = {2, 3, 5, 7};
    int[] nextNum = {1, 3, 7, 9};
    int N;
    StringBuilder result = new StringBuilder();

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 4; i++) {
            dfs(startNum[i], 1);
        }
        System.out.println(result);
    }

    void dfs(int num, int depth) {
        if (depth == N) {
            result.append(num).append("\n");
            return;
        }

        for (int i = 0; i < 4; i++) {
            int next = num * 10 + nextNum[i];
            if (isPrime(next)) {
                dfs(next, depth + 1);
            }
        }
    }



    boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2023().solution();
//    }
//}
