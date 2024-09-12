package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 톱니바퀴 (B14891)
 * 풀이: 구현
 * 메모리: 14248kb
 * 시간: 104ms
 */
public class B14891 {


    int[][] wheels = new int[4][8];
    int[][] originals;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = temp[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        originals = new int[4][8];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            moveWheels(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        int num = 1;
        // 점수 계산
        for (int i = 0; i < 4; i++) {
            if (wheels[i][0] == 1) {
                count += num;
            }
            num *= 2;
        }


        System.out.println(count);
    }

    private void moveWheels(int n, int d) {

        // 톱니바퀴를 돌려야하는 수를 저장
        int[] directions = new int[4];
        directions[n - 1] = d;

        // 왼쪽 톱니바퀴들에 대해 회전 방향 설정
        for (int i = n - 1; i > 0; i--) {
            if (isMove(i - 1, i)) {
                if (directions[i] > 0) {
                    directions[i - 1] = -1;
                } else {
                    directions[i - 1] = 1;
                }
            } else {
                break;
            }
        }

        // 오른쪽 톱니바퀴들에 대해 회전 방향 설정
        for (int i = n - 1; i < 3; i++) {
            if (isMove(i, i + 1)) {
                if (directions[i] > 0) {
                    directions[i + 1] = -1;
                } else {
                    directions[i + 1] = 1;
                }
            } else {
                break;
            }
        }

        // 모든 톱니바퀴 회전
        for (int i = 0; i < 4; i++) {
            if (directions[i] != 0) {
                moveWheel(i, directions[i]);
            }
        }
        int s = 5;
    }

    // 톱니바퀴가 돌아야하는지 확인
    private boolean isMove(int start, int target) {
        if (wheels[start][2] != wheels[target][6]) {
            return true;
        }
        return false;
    }

    // 톱니바퀴 움직이기
    private void moveWheel(int n, int d) {

        // 톱니바퀴가 돌기전에 기존 톱니바퀴를 저장
        System.arraycopy(wheels[n], 0, originals[n], 0, 8);
        for (int i = 0; i < 8; i++) {

            int move = i + d;
            if (move >= 8) { // 시계 방향으로 돌았을때 8을 초과했다면
                move = move % 8;
            }

            if (move < 0) { // 반시계 방향으로 돌았을때 0 보다 작다면
                move = 8 + move;
            }
            wheels[n][move] = originals[n][i];
        }
    }
}


//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B14891().solution();
//    }
//}
