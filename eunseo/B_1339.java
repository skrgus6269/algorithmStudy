import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제: 단어수학
 * 메모리: 11536 kb
 * 시간: 68 ms
 * 풀이: 그리디 알고리즘 활용
 *      각 알파벳의 자릿수와 빈도를 배열에 저장한 뒤 활용
 */
public class B_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[c-'A'] += (int)Math.pow(10, str.length()-1-j);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int turn = 25;
        int result = 0;
        while(arr[turn] != 0) {
            result += (arr[turn] * num);
            turn--;
            num--;
        }

        System.out.print(result);
    }
}
