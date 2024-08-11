import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제: 문자열 폭발
 * 메모리: 88968 kb
 * 시간: 468 ms
 * 풀이: 스택 사용
 */
public class B_9935 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bombLen) {
                boolean check = true;

                for(int j = 0; j < bombLen; j++) {
                    if(stack.get(stack.size()-bombLen+j) != bomb.charAt(j)) {
                        check = false;
                        break;
                    }
                }

                if(check) {
                    for(int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
