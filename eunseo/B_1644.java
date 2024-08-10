import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제: 소수의 연속합
 * 메모리: 15680 kb
 * 시간: 208 ms
 * 풀이: 에라토스테네스의 체 사용
 */
public class B_1644 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체 : 소수가 되는 수의 배수를 지우면 남은 것은 모두 소수이다.
        boolean[] prime = new boolean[N+1];

        // 0과 1은 소수가 아님
        prime[0] = prime[1] = false;

        for(int i = 2; i <= N; i++) {
            prime[i] = true;
        }

        // 2~N의 제곱근보다 작은 소수들의 배수 제외시키기
        for(int i = 2; i*i <= N; i++) {
            for(int j = i*i; j <= N; j += i) {
                prime[j] = false;
            }
        }

        int result = 0;
        for(int i = N; i > 0; i--) {
            if(!prime[i]) continue;
            int sum = 0;
            for(int j = i; j > 0; j--) {
                if(sum >= N) {
                    if(sum == N) {
                        result++;
                    }
                    break;
                }

                if(!prime[j]) continue;

                sum += j;
            }
        }

        System.out.println(result);
    }
}
