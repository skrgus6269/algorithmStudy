package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: A->B (B16953)
 * 풀이: 그리디
 * 메모리: 14296kb
 * 시간: 104ms
 */
public class B16953 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 반대로 시작하여, 시작값을 B 로 시작해 A 로 값을 만드는것을 목표로 한다.
        // 그리디를 적용하여 수가 최대한 작아지는것을 목표로 한다.
        // 마지막 1제거 VS 수를 2로 나누어주는 것중 마지막 1제거가 수를 더 작게만드므로
        // 먼저 마지막 1제거가 가능하다면 해주고,
        // 그 다음로 2로 나눌수 있다면 나누어준다.
        int answer = 1;
        int num = B;
        while (num > A) {

            // 숫자를 문자로 변환
            String stringNum = num + "";
            if (stringNum.charAt(stringNum.length() - 1) == '1') { // 마지막 문자가 1이라면
                num = Integer.parseInt(stringNum.substring(0, stringNum.length() - 1)); // 마지막 1을 제거해주고 정수형으로 변환
            } else if (num % 2 == 0) { // 숫자가 2로 나누어진다면
                num /= 2; // 수를 2로 나누어주기
            } else {
                // 마지막 문자가 1도아니고, 2로도 안나누어지면 구제불능이므로 바로 탈출
                break;
            }
            answer++;
        }

        // 결과로 나온 수가 A 가 아니면 중간에 구제불능이서 break 된 수거나 결국 num 이 A 보다 작아진 수이므로 answer = -1
        if (num != A) {
            answer = -1;
        }

        System.out.println(answer);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B16953().solution();
//    }
//}
