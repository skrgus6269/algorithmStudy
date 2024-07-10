package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제: (B15686)
 * 풀이: DFS + 백트래킹
 * 1. 집과, 치킨집의 좌표를 저장
 * 2. DFS + 백트래킹을 통한 완전탐색을 통해 치킨집 수가 M 일때만 확인
 * 3. 치킨집 수 가 M 일때 모든집에서 오픈한 치킨집에 대한 거리를 구하고 결과값 최신화
 * 메모리: 17444kb
 * 시간: 244ms
 */
public class B15686 {

    int N;
    int M;
    int result = Integer.MAX_VALUE;
    ArrayList<Point> home;
    ArrayList<Point> chicken;
    boolean[] isOpened;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 1) {
                    home.add(new Point(j, i));
                }

                if (cur == 2) {
                    chicken.add(new Point(j, i));
                }
            }
        }

        isOpened = new boolean[chicken.size()];
        dfs(0, 0);

        System.out.println(result);
    }

    private void dfs(int start, int count) {

        if (count == M) {
            int sum = 0;

            for (int i = 0; i < home.size(); i++) {
                int chickenRoad = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {

                    if (isOpened[j]) {
                        int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        chickenRoad = Math.min(chickenRoad, distance);
                    }
                }

                sum += chickenRoad;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            isOpened[i] = true;
            dfs(i + 1, count + 1);
            isOpened[i] = false;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B15686().solution();
//    }
//}
