package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 숨바꼭질2 (B12851)
 * 풀이: bfs
 * 메모리: 27376kb
 * 시간: 204ms
 */
public class B12851 {

    int[] road;
    int a, b, cnt;


    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        if(a==b) {
            cnt++;
            System.out.println(road[b]);
            System.out.println(cnt);
            return;
        }
        road = new int[100001];
        bfs();

        System.out.println(road[b]);
        System.out.println(cnt);
    }

    int[] m = {1, -1, 2};
    private void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(a);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = cur * m[i];
                } else {
                    next = cur + m[i];
                }

                if (next < 0 || next > 100000 || (road[next] != 0 && road[next] < road[cur] + 1)) {
                   continue;
                }

                road[next] = road[cur] + 1;
                q.add(next);

                if (next == b) {
                    cnt++;
                }
            }
        }

    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B12851().solution();
//    }
//}
