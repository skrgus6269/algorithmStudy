import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: DNA 비밀번호
 * 메모리: 66728 kb
 * 시간: 288ms
 * 풀이: 큐와 해시맵을 사용하여 구현
 */
public class B_12891 {
    static int result;
    static HashMap<Character, Integer> hm;
    static int[] num;
    static char[] arrC;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();
        int P = Integer.parseInt(st.nextToken());
        result = 0;
        num = new int[4];
        arrC = new char[4];

        String s = br.readLine();
        st = new StringTokenizer(br.readLine());

        hm = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        arrC[0] = 'A';
        arrC[1] = 'C';
        arrC[2] = 'G';
        arrC[3] = 'T';

        for(int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            hm.put(arrC[i], 0);
        }

        for(int i = 0; i < P; i++) {
            char c = s.charAt(i);
            q.offer(c);
            hm.put(c, hm.get(c)+1);
        }

        check();
        for(int i = P; i < s.length(); i++) {

            char outC = q.poll();
            char c = s.charAt(i);

            q.offer(c);
            hm.put(outC, hm.get(outC)-1);
            hm.put(c, hm.get(c)+1);

            check();
        }

        System.out.println(result);
    }

    private static void check() {

        boolean check = true;
        for(int i = 0; i < 4; i++) {
            if(hm.get(arrC[i]) < num[i]) {
                check = false;
            }
        }

        if(check) {
            result++;
        }

        return;
    }
}
