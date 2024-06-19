import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 도영이가 만든 맛있는 음식
 * https://www.acmicpc.net/source/79830646
 * java8 / 11616 KB / 60 ms /
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    long arr[][] = new long[N+1][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    long mn = Math.abs(arr[0][0] - arr[0][1]);
    for (int i = 0; i < 1 << N; i++) {
      long tmp = i,ssin = 1,ssen = 0;
      int k=0;
      for(long j=tmp;j>0;j=(j >> 1),k++)
        if(j%2==1){
          ssin*=arr[k][0];
          ssen+=arr[k][1];
          mn = Math.min(mn,Math.abs(ssin-ssen));
        }
    }
    System.out.println(mn);
  }
}