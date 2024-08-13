import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    BOJ 9935
    java 11 / 36004 KB / 508 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] bombString = br.readLine().toCharArray();
        int bombSize = bombString.length;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            st.push(input[i]);
            int stackSize = st.size();
            if (stackSize < bombSize) {
                continue;
            }

            boolean isSame = true;
            for (int j = 0; j < bombSize; j++) {
                if (st.get(stackSize - bombSize + j) != bombString[j]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                for (int j = 0; j < bombSize; j++) {
                    st.pop();
                }
            }
        }

        for (char ch : st) {
            sb.append(ch);
        }

        System.out.printf("%s", sb.length() == 0 ? "FRULA" : sb);
    }
}
