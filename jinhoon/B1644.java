package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제: 소수의 연속합 (B1644)
 * 풀이: 에토스테네스의 체(소수 구하기) + 투 포인터
 * 메모리: 27132kb
 * 시간: 176ms
 */
public class B1644 {

    boolean[] primeNums;
    List<Integer> primes;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("0");
            return;
        }

        primeNums = new boolean[N + 1];
        primes = new ArrayList<>();
        makePrime(N);

        int sp = -1;
        int ep = 0;
        int sum = primes.get(0);
        int result = 0;
        while (sp != primes.size() - 1) {

            if (sum <= N) {
                if (sum == N) {
                    result++;
                }
                ep++;
                if (ep > primes.size() - 1) {
                    break;
                }
                sum += primes.get(ep);
            } else if (sum > N) {
                sp++;
                sum -= primes.get(sp);
            }
        }

        System.out.println(result);
    }

    private void makePrime(int n) {
        for (int i = 2; i * i <= n; i++) {

            if (!primeNums[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primeNums[j] = true;
                }
            }

        }

        for (int i = 2; i <= n; i++) {
            if (!primeNums[i]) {
                primes.add(i);
            }
        }
    }
}


