import java.io.*;

/**
 * 문제: 신기한소수
 * 메모리: 11472 kb
 * 시간: 80ms
 * 풀이: 중복을 포함한 순열과 소수판정 사용
 */
public class B_2023 {
    static int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    static int N;
    static int result;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        result = 0;

        perm(0);

        System.out.println(sb.toString());
    }

    private static void perm(int cnt) {
        if(cnt == N) {
            sb.append(result).append("\n");
            return;
        }

        for(int i = 0; i < 10; i++) {
            int check = result*10 + nums[i];
            if(isPrime(check)) {
                result = check;
                perm(cnt+1);
                result /= 10;
            }
        }
    }

    private static boolean isPrime(int num) {
        if(num < 2) return false;

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0) {
                return false;
            }
        }

        return true;
    }
}
