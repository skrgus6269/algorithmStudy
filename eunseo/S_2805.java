import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제: 2805 농작물 수확하기
 * 메모리: 24,712 kb
 * 시간: 133 ms
 * 풀이: (구현) 농장 가로 기준 절반에서 두개씩 늘리면서 더하다가 세로 기준 반 이상 오면 두개씩 줄이면서 더함
 */
public class S_2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int item = N/2;
            int w = 1;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                String s = br.readLine();
                for(int j = item; j < item+w; j++) {
                    sum += s.charAt(j) - '0';
                }

                if(i < N/2) {
                    w+=2;
                    item--;
                } else {
                    w-=2;
                    item++;
                }
            }

            System.out.println("#" + t + " " + sum);
        }
    }
}
