package BJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * [2178]미로 탐색
 * https://www.acmicpc.net/source/80642077
 * java8 / 19164 KB / 208 ms /
 */
public class Main {
  static final int []dx = {1,0,-1,0};
  static final int []dy = {0,1,0,-1};
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    StringBuilder sb = new StringBuilder();
    boolean [][]mp = new boolean[101][101];
    boolean [][]vst = new boolean[101][101];
    int answer = 0;
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    for(int i=0;i<N;i++){
      String str = bf.readLine();
      for(int j=0;j<M;j++){
        mp[i][j] = str.charAt(j) == '1';
      }
    }
    PriorityQueue<Pos> pq = new PriorityQueue<>((Pos p1,Pos p2) -> p1.distance-p2.distance);
    pq.add(new Pos(0,0,1));
    while(!pq.isEmpty()) {
      Pos cur = pq.poll();
      if (cur.y == N - 1 && cur.x == M - 1) {
        answer = cur.distance;
        break;
      }
      for (int i = 0; i < 4; i++) {
        Pos n = new Pos(cur.y + dy[i], cur.x + dx[i], cur.distance + 1);
        if (!isIn(n, N, M)) continue;
        if (!mp[n.y][n.x]) continue;
        if (vst[n.y][n.x]) continue;
        vst[n.y][n.x] = true;
        pq.add(n);
      }
    }
    System.out.println(answer);
  }
  static boolean isIn(Pos p,int N,int M){
    if(p.y < 0 || p.y >= N || p.x < 0 || p.x >= M) return false;
    return true;
  }
  static class Pos{
    int y;
    int x;
    int distance;

    public Pos(int y, int x, int distance) {
      this.y = y;
      this.x = x;
      this.distance = distance;
    }
  }

}