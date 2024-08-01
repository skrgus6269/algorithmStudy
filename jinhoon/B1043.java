package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 거짓말 (B1043)
 * 풀이: union-find
 * 메모리: 14252kb
 * 시간: 128ms
 */
public class B1043 {

    int[] parent;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] tmans = new int[T];
        for (int i = 0; i < T; i++) {
            tmans[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            for (int j = 0; j < P; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 대표를 기준으로 집합 구성
        for (int i = 0; i < M; i++) {
            int rep = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(rep, party[i].get(j));
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            int rep = party[i].get(0);
            boolean chk = true;
            for (int j = 0; j < T; j++) {
                if (find(rep) == find(tmans[j])) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                count++;
            }
        }

        System.out.println(count);
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }

    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1043().solution();
//    }
//}
