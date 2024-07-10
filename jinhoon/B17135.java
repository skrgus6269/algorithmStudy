package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제: (B17135)
 * 풀이: 구현
 * 1. 조합을 통해 궁수 3마리를 배치한다.
 * 2. 배치가 끝나면 각 궁수마다 최단거리, 왼쪽에 있는적을 우선으로 공격한다.
 * 3. 궁수는 같은 적을 공격할 수 있으므로 모든 궁수가 공격할 대상을 정한 후 공격을 처리한다.
 * 4. 공격 처리후 적이 한칸 앞으로 전진한다.
 * 5. 단계를 진행한다.
 * 메모리: 24792kb
 * 시간: 332ms
 */
public class B17135 {

    int N;
    int M;
    int D;
    int[][] map;
    int[][] tempMap;
    int result;
    List<Integer> archers;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        tempMap = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                tempMap[i][j] = num;
            }
        }

        archers = new ArrayList<>();
        result = 0;
        comb(1, M, 3);

        System.out.println(result);
    }

    // 조합을 통해 궁수배치
    private void comb(int start, int n, int r) {

        if (r == 0) {
            init();
            attack();
            return;
        }

        for (int i = start; i <= n; i++) {
            archers.add(i);
            comb(i + 1, n, r - 1);
            archers.remove(archers.size() - 1);
        }

    }

    // 맵 초기화
    private void init() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                map[i][j] = tempMap[i][j];
            }
        }
    }

    // 거리 계산
    private int calDistance(int a1, int a2, int b1, int b2) {
        return Math.abs(a1 - a2) + Math.abs(b1 - b2);
    }

    // 공격
    private void attack() {
        int res = 0;

        for (int n = 1; n <= N; n++) {
            boolean[][] visited = new boolean[N + 1][M + 1];
            // 공격거리, 좌표 계산
            for (int k = 0; k < archers.size(); k++) {
                int temp = archers.get(k);
                int minD = Integer.MAX_VALUE;
                int minR = Integer.MAX_VALUE;
                int minC = Integer.MAX_VALUE;

                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if (map[i][j] == 1) { // 적이 있을 경우
                            int distance = calDistance(i, N + 1, j, temp);

                            // 현재 구한 최단리리 보다 더 짧은 거리일경우 최단거리, 좌표 갱신
                            if (distance < minD) {
                                minD = distance;
                                minR = i;
                                minC = j;
                            }

                            // 현재 구한 최단거리와 같고, 왼쪽에 적이 존재한다면 왼쪽의 적을 처치하도록함
                            if (distance == minD && minC > j) {
                                minR = i;
                                minC = j;
                            }
                        }
                    }
                }

                // 공격 좌표, 거리 계산결과 공격가능한 거리일시 해당 좌표 공격처리
                if (minD <= D) {
                    visited[minR][minC] = true;
                }
            }

            // 공격 좌표 처리
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 0;
                        res++;
                    }
                }
            }

            // 성 바로 위 줄을 모두 0으로 초기화.
            for (int i = 1; i <= M; i++) {
                map[N][i] = 0;
            }

            // i번째 줄을 i-1번째 줄로 초기화.
            for (int i = N; i >= 1; i--) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }

        result = Math.max(result, res);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B17135().solution();
//    }
//}
