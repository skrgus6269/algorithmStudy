package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제: 요세푸스 문제 (B1158)
 * 풀이: LinkedList 이용, 큐도 가능
 * 메모리: 14916kb
 * 시간: 168ms
 */
public class B1158 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        int index = 0;
        result.append("<");
        for (int i = N; i > 1; i--) {
            index = (index + K - 1) % i;
            result.append(numbers.remove(index)).append(", ");
        }
        result.append(numbers.get(0)).append(">");

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1158().solution();
//    }
//}
