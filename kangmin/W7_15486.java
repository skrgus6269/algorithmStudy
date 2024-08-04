import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    BOJ 15486
    java 11 / 338880 KB / 736 ms
 */
public class Main {
    static int N;
    static Task[] tasks;
    static int[] dp;
    static class Task {
        int time;
        int reward;

        public Task(int time, int reward) {
            this.time = time;
            this.reward = reward;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tasks = new Task[N];
        dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(time, reward);
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = Math.max(dp[i], max);
            int nextTime = i + tasks[i].time;
            if(nextTime <= N){
                dp[nextTime] = Math.max(dp[nextTime], dp[i] + tasks[i].reward);
            }
            max = Math.max(dp[i], max);
        }
        int answer = Math.max(dp[N - 1], dp[N]);
        System.out.print(answer);
    }
}
