package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 랜선 자르기
 * https://www.acmicpc.net/source/80361689
 * java8 / 15388 KB / 136 ms /
 */
public class Main {
  static long []arr;
  static int K,N;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(bf.readLine());
    // 이분탐색 문제 O(K) 32log2 * K
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = new long[K+1];
    long start = 0,end = Integer.MAX_VALUE* 2L;
    for (int i = 0; i < K; i++) {
      arr[i] = Integer.parseInt(bf.readLine());
    }
    long mx = 0;
    long mid = 0;
    while(start <= end){
      mid = (start+end)/2;
      if(cal(mid) >= N){
        mx = Math.max(mx,mid);
        start = mid+1;
      }
      else{
        end = mid-1;
      }
    }
    System.out.println(mx);
  }
  static long cal(long mid){
    long result =0;
    for (int i = 0; i < K; i++) result+=(arr[i]/mid);
    return result;
  }
}