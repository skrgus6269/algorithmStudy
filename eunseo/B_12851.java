import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: 숨바꼭질 2
 * 메모리: 39768 kb
 * 시간: 152 ms
 * 풀이: bfs 사용
 */
public class B_12851 {
    static int[] move = {1, -1, 2};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 수빈이와 동생의 위치가 같음
        if(N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int[] time = new int[100001];
        int result = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i < 3; i++) {
                int next;
                if(i==2) {
                    next = current * move[i]; // 순간이동
                } else {
                    next = current + move[i]; // 걷기
                }

                if(next < 0 || next > 100000 || (time[next] != 0 && time[next] < time[current]+1)) continue;

                time[next] = time[current] + 1;
                queue.offer(next);

                if(next == K) {
                    result++;
                }
            }
        }

        System.out.println(time[K]);
        System.out.println(result);
    }
}
