import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제: 탑
 * 메모리: 107848 kb
 * 시간: 664 ms
 * 풀이: for문 구현은 시간 초과 -> stack 사용
 */
public class B_2493 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());

            while(true) {
                if(stack.isEmpty()) {
                    sb.append(0).append(" ");
                    break;
                } else if(stack.peek()[0] > h) {
                    sb.append(stack.peek()[1]).append(" ");
                    break;
                } else {
                    stack.pop();
                }
            }

            stack.add(new int[] {h, i+1});
        }

        System.out.println(sb);
    }
}
