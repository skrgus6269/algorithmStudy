package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제: 암호만들기 (B1759)
 * 풀이: DFS + 백트래킹
 * 메모리: 17996kb
 * 시간: 160ms
 */
public class B1759 {

    int L, C;
    char[] alpa;
    boolean[] isVisited;
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    StringBuilder result;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpa = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpa[i] = st.nextToken().charAt(0);
        }
        isVisited = new boolean[C];
        Arrays.sort(alpa);
        dfs(0, 0, "", 0);

        System.out.println(result);
    }

    private void dfs(int start, int count, String password, int vowelCount) {

        // 글자수가 L 이 되었을때 + 모음 1개, 자음2개 이상으로 구성
        if (count == L && vowelCount >= 1 && L - vowelCount >= 2) {

            result.append(password).append("\n");
            return;
        }

        for (int i = start; i < C; i++) {

            if (!isVisited[i]) {
                isVisited[i] = true;
                if (vowels.contains(alpa[i])) {
                    vowelCount++;
                }
                dfs(i+1, count+1, password + alpa[i], vowelCount);
                isVisited[i] = false;
                if (vowels.contains(alpa[i])) {
                    vowelCount--;
                }
            }
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1759().solution();
//    }
//}
