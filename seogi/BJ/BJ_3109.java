package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 빵집
 * https://www.acmicpc.net/source/81026655
 * java8 / 	107296 KB / 344 ms /
 */
public class Main {
  static int d[][] = {{-1,1},{0,1},{1,1}};
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb;
  static StringTokenizer st;
  static boolean vst[][];
  static boolean isReach;
  static int N,M;
  public static void main(String[] args) throws IOException{
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    vst = new boolean[N][M];
    for(int i=0;i<N;i++) {
      String tmp = br.readLine();
      for (int j = 0; j < M; j++) {
        vst[i][j] = tmp.charAt(j) == 'x';
      }
    }
    int answer = 0;
    for(int i=0;i<N;i++){
      isReach = false;
      Pos cur = new Pos(i,0);
      cur.setV(true);
      dfs(cur);
      if(isReach) answer++;
    }
    System.out.println(answer);
  }
  // cur은 현재 x좌표
  static void dfs(Pos cur){
    if(isReach) return;
    if(cur.x == M-1){
      isReach = true;
      return;
    }
    boolean block = true;
    for(int i=0;i<3;i++){
      Pos nx = new Pos(cur.y+d[i][0],cur.x+d[i][1]);
      if(!nx.isIn()||nx.isV()) continue;
      // 만약에 가는 길이 없었으면 돌아온다.
      nx.setV(true);
      dfs(nx);
      if(isReach) return;
    }
  }

  static class Pos{
    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
    public void setV(boolean b){
      vst[this.y][this.x] = b;
    }
    public boolean isV(){
      return vst[this.y][this.x];
    }
    public boolean isIn(){
      if(this.x < 0 || this.x >= M || this.y < 0 || this.y >= N) return false;
      return true;
    }
  }
}