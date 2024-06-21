package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제: DNA 비밀번호 (12891)
 * 풀이 : 해쉬맵을 활용해 구현
 * 메모리: 47356kb
 * 시간: 464ms
 */
public class B12891 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String plain = br.readLine();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Map<Character, Integer> count = new HashMap<>();
        count.put('A', 0);
        count.put('C', 0);
        count.put('G', 0);
        count.put('T', 0);

        for (int i = 0; i < P; i++) {
            char key = plain.charAt(i);
            count.put(key, count.get(key) + 1);
        }

        int result = 0;

        // 암호 조건을 만족한다면 수 추가
        if (count.get('A') >= A
                && count.get('C') >= C
                && count.get('G') >= G
                && count.get('T') >= T) {
            result++;
        }

        for (int i = P; i < S; i++) {

            char preKey = plain.charAt(i - P);
            char nextKey = plain.charAt(i);

            // 이전키 제거, 다음키 추가
            count.put(preKey, count.get(preKey) - 1);
            count.put(nextKey, count.get(nextKey) + 1);

            // 암호 조건을 만족한다면 수 추가
            if (count.get('A') >= A
                    && count.get('C') >= C
                    && count.get('G') >= G
                    && count.get('T') >= T) {
                result++;
            }
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B12891().solution();
//    }
//}
