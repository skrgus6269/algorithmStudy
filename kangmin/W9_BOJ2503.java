import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    BOJ 2503
    java 11 / 14484 KB / 112 ms
 */
public class Main {

    static class Question {
        String number;
        int strike;
        int ball;

        public Question(StringTokenizer st) {
            number = st.nextToken();
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        List<Question> questions = new ArrayList<>();
        int answer = 0;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            questions.add(new Question(st));
        }

        for (int i = 123; i <= 987; i++) {
            boolean answerFlag = true;
            String number = String.valueOf(i);
            if (!isValidNumber(number)) {
                continue;
            }

            for (Question question : questions) {
                int strikeCount = 0;
                int ballCont = 0;
                for (int j = 0; j < 3; j++) {
                    if (number.charAt(j) == question.number.charAt(j)) {
                        strikeCount++;
                    }
                }

                if (strikeCount != question.strike) {
                    answerFlag = false;
                    break;
                }

                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        }

                        if (number.charAt(j) == question.number.charAt(k)) {
                            ballCont++;
                        }
                    }
                }

                if (ballCont != question.ball) {
                    answerFlag = false;
                    break;
                }
            }

            if (answerFlag) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    static boolean isValidNumber(String target) {
        if (target.contains("0")) {
            return false;
        }

        if (target.charAt(0) == target.charAt(1)
            || target.charAt(0) == target.charAt(2)
            || target.charAt(1) == target.charAt(2)) {
            return false;
        }

        return true;
    }
}
