import java.io.*;

/**
 * 문제: IOIOI
 * 메모리: 20852 kb
 * 시간: 204 ms
 * 풀이: 단순 구현
 */
public class B_5525 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int check = 0;
        int result = 0;
        for(int i = 0; i < S.length()-2; i++) {
            if(S.charAt(i) == 'I' && S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I') {
                check++;
                i++;
            } else {
                check = 0;
            }

            if(check == N) {
                result++;
                check--;
            }
        }

        System.out.println(result);
    }
}
