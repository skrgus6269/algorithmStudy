import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 문제: 과일 탕후루
 * 메모리: 35984 kb
 * 시간: 328 ms
 * 풀이: 투 포인터 사용
 *      - 연속된 부분 수열을 처리할 때 매우 효과적
 *      - 배열의 한쪽 끝에서 다른 쪽 끝까지 이동하면서 조건을 만족하는 가장 긴 구간을 찾는 데 적합
 */
public class B_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] fruit = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> fruitsCnt = new HashMap<>();
        int result = 0;
        int left = 0;

        for(int right = 0; right < N; right++) {
            fruitsCnt.put(fruit[right], fruitsCnt.getOrDefault(fruit[right], 0) + 1);   // 오른쪽은 점점 뒤로

            while(fruitsCnt.size() > 2) {
                fruitsCnt.put(fruit[left], fruitsCnt.get(fruit[left]) - 1);

                if(fruitsCnt.get(fruit[left]) == 0) {
                    fruitsCnt.remove(fruit[left]);
                }

                left++;    // 왼쪽은 과일 종류 2가지 이상이 될때마다 뒤로
            }

            result = Math.max(result, right-left+1);
        }

        System.out.println(result);
    }
}
