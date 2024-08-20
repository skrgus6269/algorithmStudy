import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 문제: 암호 만들기
 * 메모리: 15640 kb
 * 시간: 148 ms
 * 풀이: 조합 사용
 */
public class B_1759 {
    static int L, C;
    static List<String> result;
    static int count = 0;
    static List<String> alpha;
    static String[] str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        alpha = new ArrayList<>();
        result = new ArrayList<>();
        str = new String[L];

        for (int i = 0; i < C; i++) {
            alpha.add(sc.next());
        }

        comb(0, 0, 0, 0);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    private static void comb(int cnt, int start, int moNum, int zaNum) {
        if (cnt == L) {
            if (moNum >= 1 && zaNum >= 2) {
                String[] strCopy = Arrays.copyOf(str, str.length);
                Arrays.sort(strCopy);
                String s = String.join("", strCopy);
                result.add(s);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            str[cnt] = alpha.get(i);
            if (str[cnt].equals("a") || str[cnt].equals("e") || str[cnt].equals("i") || str[cnt].equals("o")
                    || str[cnt].equals("u"))
                comb(cnt + 1, i + 1, moNum + 1, zaNum);
            else
                comb(cnt + 1, i + 1, moNum, zaNum + 1);

        }
    }
}
