import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 줄 세우기
 * 메모리: 46424 kb
 * 시간: 416 ms
 * 풀이: 위상 정렬(방향 비순환 그래프일 때만 사용가능), 이차원 list 사용
 */
public class B_2252 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> arr = new ArrayList<>();

        for(int i = 0; i <= N ; i++) {
            arr.add(new ArrayList<>());
        }

        int[] count = new int[N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr.get(A).add(B);
            count[B] += 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(count[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            for(int next : arr.get(current)) {
                count[next]--;
                if(count[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
