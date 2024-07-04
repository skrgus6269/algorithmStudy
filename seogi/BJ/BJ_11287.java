package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 11286 절댓값 힙
 * https://www.acmicpc.net/source/80529431
 * java8 / 29528 KB / 460 ms /
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        Comparator.comparingInt((Integer n) -> Math.abs(n)).thenComparingInt(n -> n)
    );
    int N = Integer.parseInt(bf.readLine());
    for (int i = 0; i < N; i++) {
      int cur = Integer.parseInt(bf.readLine());
      if(cur == 0) {
        StringBuilder b =
            !pq.isEmpty() ? sb.append(pq.poll()).append("\n") : sb.append("0\n");
      }
      else{
        pq.add(cur);
      }
    }
    System.out.println(sb);
  }
}