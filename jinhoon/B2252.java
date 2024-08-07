package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: 줄 세우기 (B2252)
 * 풀이: 위상정렬
 * 메모리: 47740kb
 * 시간: 472ms
 */
public class B2252 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCount = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            edgeCount[second]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            result.append(cur).append(" ");

            ArrayList<Integer> list = graph.get(cur);

            for (int num : list) {
                edgeCount[num]--;
                if (edgeCount[num] == 0) {
                    q.offer(num);
                }
            }
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2252().solution();
//    }
//}
