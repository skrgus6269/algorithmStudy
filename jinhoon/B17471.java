package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 게리멘더링 (B17471)
 * 풀이: 조합(dfs) + bfs
 * 메모리: 15180kb
 * 시간: 160ms
 */
public class B17471 {

    int N;
    Point[] points;
    List<List<Integer>> graph;
    int result = Integer.MAX_VALUE;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new Point[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int P = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, P);
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Integer> A = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) {
            comb(1, N, i, A);
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        System.out.println(result);
    }

    // 조합
    private void comb(int start, int n, int r, List<Integer> A) {
        if (r == 0) {
            gerry(A);
            return;
        }

        for (int i = start; i <= n; i++) {
            A.add(i);
            comb(i + 1, n, r - 1, A);
            A.remove(A.size() - 1);
        }
    }

    private void gerry(List<Integer> A) {
        if (!isConnect(A)) {
            return;
        }

        List<Integer> B = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!A.contains(i)) {
                B.add(i);
            }
        }

        if (!isConnect(B)) {
            return;
        }

        int resultA = 0;
        for (int i = 0; i < A.size(); i++) {
            resultA += points[A.get(i)].pNum;
        }

        int resultB = 0;
        for (int i = 0; i < B.size(); i++) {
            resultB += points[B.get(i)].pNum;
        }

        result = Math.min(result, Math.abs(resultA - resultB));
    }

    private boolean isConnect(List<Integer> A) {
        boolean[] visited = new boolean[N + 1];
        int num = points[A.get(0)].rNum;
        int size = A.size();
        visited[num] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : graph.get(cur)) {
                if (!visited[i] && A.contains(i)) {
                    visited[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }
        return count == size;
    }

    static class Point {
        int rNum;
        int pNum;

        public Point(int rNum, int pNum) {
            this.rNum = rNum;
            this.pNum = pNum;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B17471().solution();
//    }
//}
