package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 다리 만들기2 (B17472)
 * 풀이: BFS + 크루스칼 + 구현
 * 메모리: 14304kb
 * 시간: 100ms
 */
public class B17472 {

    int N, M, map[][], bridgeMap[][], parents[];
    boolean visited[][];
    List<Bridge> bridges;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        int landNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    checkIsland(i, j, landNum++);
                }
            }
        }

        bridgeMap = new int[landNum][landNum];
        for (int i = 1; i < landNum; i++) {
            Arrays.fill(bridgeMap[i], Integer.MAX_VALUE);
        }

        makeBridge();

        parents = new int[landNum];
        for (int i = 1; i < landNum; i++) {
            parents[i] = i;
        }

        bridges = new ArrayList<>();
        for (int i = 1; i < landNum; i++) {
            for (int j = i + 1; j < landNum; j++) {
                if (bridgeMap[i][j] != Integer.MAX_VALUE) {
                    bridges.add(new Bridge(i, j, bridgeMap[i][j]));
                }
            }
        }

        Collections.sort(bridges);

        int result = connect();

        if (!isAllConnected(landNum)) {
            result = -1;
        }

        System.out.println(result);
    }

    private boolean isAllConnected(int landNum) {
        int num = find(1);
        for (int i = 2; i < landNum; i++) {
            if (num != find(i)) {
                return false;
            }
        }
        return true;
    }

    private int connect() {
        int answer = 0;
        for (Bridge bridge : bridges) {
            if (union(bridge.start, bridge.end)) {
                answer += bridge.size;
            }
        }
        return answer;
    }

    private boolean union(int land1, int land2) {
        int root1 = find(land1);
        int root2 = find(land2);

        if (root1 == root2) return false;

        if (root1 > root2) {
            parents[root1] = root2;
        } else {
            parents[root2] = root1;
        }
        return true;
    }

    private int find(int land) {
        if (land == parents[land]) {
            return land;
        }
        return parents[land] = find(parents[land]);
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private void makeBridge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] > 0) {
                    int land = map[i][j];

                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        // 바다라면
                        if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] == 0) {

                            int mx = nx;
                            int my = ny;
                            int size = 0;

                            // 시작섬을 기준으로 4방위 탐색을 통해 다른섬에 대한 다리의 크기를 구함
                            while (mx >= 0 && mx < M && my >= 0 && my < N) {
                                int next = map[my][mx];

                                if (next > 0 && next != land && size > 1) {
                                    bridgeMap[land][next] = Math.min(bridgeMap[land][next], size);
                                    bridgeMap[next][land] = Math.min(bridgeMap[next][land], size);
                                    break;
                                } else if (land > 0 && next > 0 && land != next && size < 2) {
                                    break;
                                } else if (map[i][j] == map[my][mx]) {
                                    break;
                                }

                                mx += dx[k];
                                my += dy[k];
                                size++;
                            }
                        }
                    }
                }
            }
        }
    }


    private void checkIsland(int y, int x, int land) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        map[y][x] = land;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = land;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }

    static class Bridge implements Comparable<Bridge> {
        int start, end, size;

        public Bridge(int start, int end, int size) {
            this.start = start;
            this.end = end;
            this.size = size;
        }

        @Override
        public int compareTo(Bridge o) {
            return this.size - o.size;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B17472().solution();
//    }
//}
