import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
    BOJ 5430 AC
    java 11 / 97696 KB / 888ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String commands = br.readLine();
            int count = Integer.parseInt(br.readLine());
            Deque<Integer> deque = createDequeBy(br.readLine(), count);
            Boolean isFirst = true;
            Boolean isError = false;

            for (int j = 0; j < commands.length(); j++) {
                String command = String.valueOf(commands.charAt(j));
                if (command.equals("R")) {
                    isFirst = !isFirst;
                } else if (command.equals("D")) {
                    if (deque.isEmpty()) {
                        isError = true;
                        sb.append("error\n");
                        break;
                    }

                    if (isFirst) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if (isError) {
                continue;
            }

            sb.append("[");
            while (!deque.isEmpty()) {
                int num;
                if (isFirst) {
                    num = deque.removeFirst();
                } else {
                    num = deque.removeLast();
                }
                sb.append(num);

                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]\n");
        }
        System.out.print(sb.toString().trim());
    }

    static Deque<Integer> createDequeBy(String input, int count) {
        Deque<Integer> deque = new ArrayDeque<>();
        if (count == 0) {
            return deque;
        }
        input = input.substring(1, input.length() - 1);
        StringTokenizer st = new StringTokenizer(input, ",");
        for (int i = 0; i < count; i++) {
            deque.addLast(Integer.parseInt(st.nextToken()));
        }

        return deque;
    }
}

