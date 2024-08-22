import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 센서
 * 메모리: 15104 kb
 * 시간: 128 ms
 * 풀이: 정렬, 우선순위 큐 사용
 */
public class B_2212_센서 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int result = 0;

        int[] road = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(road);

        Queue<Integer> queue = new PriorityQueue<>();

        for(int i = 1; i < N; i++) {
            queue.offer(road[i] - road[i-1]);
        }

        for(int i = 0; i < N-K; i++) {
            result += queue.poll();
        }

        System.out.println(result);
    }
}
