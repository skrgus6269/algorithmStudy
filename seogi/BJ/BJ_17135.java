package BJ;

import java.io.*;
import java.util.*;
/*
 * 캐슬디팬스
 * https://www.acmicpc.net/source/56344019
 * java8 / 48264 KB / 284 ms /
 */
public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int N,M,D;
  static boolean vst[];
  static int MAX = 200001;
  static int mp[][];
  static int origin[][];
  static int archer[] = {0,1,2};
  static int cnt =0;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    origin = new int[N+1][M];
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0;j<M;j++){
        origin[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int answer = 0;
    for(archer[0]=0; archer[0]<M; archer[0]++){
      for(archer[1]=archer[0]+1;archer[1]<archer[2]; archer[1]++){
        for(archer[2]=archer[1]+1;archer[2]< M; archer[2]++){
          cnt=0;
          OtoM();
          for(int i=0;i<N;i++){
            attack();
            move();
          }
          answer = Math.max(cnt,answer);
        }
      }
    }
    System.out.println(answer);
  }
  static void move(){
    for(int i=N-1;i>=0;i--){
      for(int j=0;j<M;j++){
        if(i == N-1){
          if(mp[i][j] == 1)
            mp[i][j] = 0;
          continue;
        }
        if(mp[i][j] == 1){
          mp[i][j] = 0;
          mp[i+1][j] = 1;
        }
      }
    }
  }
  static void attack(){
    ArrayList<Pos> enemy = new ArrayList<>();
    for(int arch : archer){
      int dis = D;
      Pos e = new Pos(100,100);
      for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
          if(mp[i][j] == 1){
            int cur = getDistance(new Pos(i,j),new Pos(N,arch));
            if(cur == dis && e.x < j) continue;
            if(cur <= dis){
              dis = cur;
              e = new Pos(i,j);
            }
          }
        }
      }
      enemy.add(e);
    }
    for(Pos cur : enemy){
      if(cur.x == 100) continue;
      if(mp[cur.y][cur.x] == 0) continue;
      mp[cur.y][cur.x] = 0;
      cnt++;
    }
  }
  static int getDistance(Pos p1,Pos p2){
    return Math.abs(p1.y - p2.y) + Math.abs(p1.x-p2.x);
  }
  static void OtoM(){
    mp = new int[N][M];
    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        mp[i][j] = origin[i][j];
      }
    }
  }
  static class Pos{
    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}
