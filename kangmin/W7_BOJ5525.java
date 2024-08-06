import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 5525
    java 11 / 21992 KB / 268 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int i = 1;
        int result = 0;
        int count = 0;

        while (i < M - 1) {
            if (input[i] == 'O' && input[i + 1] == 'I') {
                count++;
                i += 2;
                if (count == N) {
                    if (input[i - 2 * count - 1] == 'I') {
                        result++;
                    }
                    count--;
                }
                continue;
            }

            i++;
            count = 0;
        }

        System.out.print(result);
    }


}

