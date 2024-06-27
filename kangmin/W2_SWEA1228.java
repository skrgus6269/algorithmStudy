import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    java8/ 21500KB /109ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 10; t++) {
            List<String> encText = new ArrayList<>();
            int length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < length; i++) {
                encText.add(st.nextToken());
            }

            int commandCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < commandCount; i++) {
                st.nextToken();
                int location = Integer.parseInt(st.nextToken());
                int numCount = Integer.parseInt(st.nextToken());

                for (int j = 0; j < numCount; j++) {
                    encText.add(location++, st.nextToken());
                }
            }

            sb.append(String.format("#%d %s", t + 1, String.join(" ", encText.subList(0, 10)))).append("\n");
        }

        System.out.print(sb.toString());
    }
}
