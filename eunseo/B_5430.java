import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 문제: AC
 * 메모리: 115900 kb
 * 시간: 664 ms
 * 풀이: Deque 활용하여 직접 swap 하지 않고 시작점과 끝점을 바꿔가면서 풀이
 */
public class B_5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String P = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String nums = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            for(String str : nums.substring(1, nums.length()-1).split(",")) {
                if (!str.equals("")) {
                    deque.add(Integer.parseInt(str));
                }
            }

            boolean reverse = false;
            boolean isError = false;
            for(int i = 0; i < P.length(); i++) {

                if(P.charAt(i) == 'R') {
                    reverse = !reverse;
                    continue;
                }

                if(deque.size() == 0) {
                    isError = true;
                    break;
                }

                if(P.charAt(i) == 'D' && reverse) {
                    deque.removeLast();
                    continue;
                }

                if(P.charAt(i) == 'D' && !reverse) {
                    deque.removeFirst();
                    continue;
                }

            }

            if(isError) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder("[");
            while (!deque.isEmpty()) {
                if(reverse) {
                    sb.append(deque.removeLast());
                } else {
                    sb.append(deque.removeFirst());
                }

                if(deque.size() != 0) {
                    sb.append(",");
                }
            }

            sb.append("]");
            System.out.println(sb);
        }
    }
}
