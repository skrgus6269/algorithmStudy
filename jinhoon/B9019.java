package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: DSLR (B9019)
 * 풀이: 큐
 * 메모리: 303372kb
 * 시간: 3860ms
 */
public class B9019 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            result.append(bfs(from, to)).append("\n");
        }

        System.out.println(result);

        System.out.println(result);
    }

    private String bfs(int start, int to) {
        Queue<Record> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        q.offer(new Record(start, ""));
        visited[start] = true;


        while (!q.isEmpty()) {
            Record cur = q.poll();
            if (cur.num == to) {
                return cur.command;
            }

            int next;
            if (cur.num * 2 > 9999) {
                next = (cur.num * 2) % 10000;
            } else {
                next = cur.num * 2;
            }
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Record(next, cur.command + "D"));
            }

            if (cur.num == 0) {
                next = 9999;
            } else {
                next = cur.num - 1;
            }
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Record(next, cur.command + "S"));
            }

            int leftNum = cur.num / 1000;
            next = (cur.num % 1000) * 10 + leftNum;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Record(next, cur.command + "L"));
            }

            int rightNum = cur.num % 10;
            next = (cur.num / 10) + 1000 * rightNum;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(new Record(next, cur.command + "R"));
            }
        }

        return "ERROR";
    }

    class Record {
        int num;
        String command;

        public Record(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B9019().solution();
//    }
//}
