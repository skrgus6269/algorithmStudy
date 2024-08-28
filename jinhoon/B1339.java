package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 문제: 단어수학 (B1339)
 * 풀이: 완
 * 메모리: 264048kb
 * 시간: 1140ms
 */
public class B1339 {
    int N;
    int[] alpaMap = new int[26];
    char[][] alpas;
    Set<Character> alpaType;
    long maxNum;
    int targetNum;
    boolean[] visit;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        alpaType = new HashSet<>(); // 알파벳의 종류 확인용
        alpas = new char[N][]; // 실제 알파벳
        for (int i = 0; i < N; i++) {
            alpas[i] = br.readLine().toCharArray();
            for (char c : alpas[i]) {
                alpaType.add(c);
            }
        }

        targetNum = 9 - alpaType.size(); // dfs 에서 기저조건
        visit = new boolean[26];
        // 제일 큰 수인 9부터 시작해서 내려간다.
        dfs(9);

        System.out.println(maxNum);
    }

    private void dfs(int count) {

        // 기저조건을 만족하면
        if (count == targetNum) {

            // 세팅된 알파벳 맵을 이용하여
            // 각 알파벳들을 "수" 로 바꿔서 전부 합해준다.
            long sum = 0;
            for (char[] alpa : alpas) {

                int num = 0;
                for (int i = 0; i < alpa.length; i++) {
                    num *= 10;
                    num += alpaMap[alpa[i] - 'A'];
                }
                sum += num;
            }

            // 최댓값 업데이트
            maxNum = Math.max(maxNum, sum);
            return;
        }

        // 각 알파벳에 대하여 1~9 를 세팅한다.
        for (char n : alpaType) {
            int aNum = n - 'A';
            if (!visit[aNum]) {
                visit[aNum] = true;
                alpaMap[aNum] = count;
                dfs(count - 1);
                visit[aNum] = false;
            }
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1339().solution();
//    }
//}
