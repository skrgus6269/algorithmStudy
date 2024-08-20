package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제: 숫자 야구 (B2503)
 * 풀이: 완탐
 * 메모리: 14452kb
 * 시간: 144ms
 */
public class B2503 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i] = new Question(st.nextToken().toCharArray(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        // 가능한 정답에 대해 완전탐색 진행
        for (int i = 123; i <= 987; i++) {

            char[] iChars = (i + "").toCharArray();
            if (iChars[0] == '0' || iChars[1] == '0' || iChars[2] == '0' ||
                    iChars[0] == iChars[1] || iChars[0] == iChars[2] || iChars[1] == iChars[2]) {
                // 133 과 같이 존재할 수 없는 정답의 경우 패스
                continue;
            }

            int check = 1;
            // 모든 질문에 대해 만족하는지 확인
            for (Question q : questions) {
                if (!q.judge(iChars)) { // 질문의 판단이 틀린경우 바로 탈출
                    check = 0;
                    break;
                }
            }

            result += check;
        }

        System.out.println(result);
    }

    static class Question {

        Set<Character> numbers;
        char[] quest;
        int strike;
        int ball;

        public Question(char[] quest, int strike, int ball) {
            this.quest = quest;
            this.strike = strike;
            this.ball = ball;
            numbers = new HashSet<>(Arrays.asList(quest[0], quest[1], quest[2]));
        }

        // 주어진 숫자를 판단하여 질문한 볼과 스트라이크의 개수가 같다면 true 를 반환한다.
        public boolean judge(char[] num) {

            int countStrike = 0;
            int countBall = 0;
            for (int i = 0; i < 3; i++) {
                if (quest[i] == num[i]) { // 같은 위치에 같은 숫자라면 스트라이크
                    countStrike++;
                } else if (numbers.contains(num[i])) { // 같은 위치는 아니지만 해당 숫자를 가지고는 있다면 볼
                    countBall++;
                }
            }

            return countStrike == this.strike && countBall == this.ball;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2503().solution();
//    }
//}
