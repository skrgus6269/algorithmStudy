package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: 회의실 배정 (B1931)
 * 풀이: 그리
 * 메모리: 45132kb
 * 시간: 508ms
 */
public class B1931 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meet[] meets = new Meet[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meets[i] = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meets);
        ArrayList<Meet> result = new ArrayList<>();
        result.add(meets[0]);

        for (int i = 1; i < N; i++) {
            if (result.get(result.size() - 1).end <= meets[i].start) {
                result.add(meets[i]);
            }
        }

        System.out.println(result.size());
    }

    static class Meet implements Comparable<Meet> {

        int start, end;

        public Meet(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            // TODO Auto-generated method stub
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }

    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1931().solution();
//    }
//}
