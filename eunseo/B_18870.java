import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 문제: 좌표 압축
 * 메모리: 360828 kb
 * 시간: 1972 ms
 * 풀이: HashMap을 사용해서 값들을 정렬한 nums 값을 key로 순위를 value로 저장해서 활용
 */
public class B_18870 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int[] sortNums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sortNums[i] = nums[i];
        }

        Arrays.sort(sortNums);

        HashMap<Integer, Integer> hm = new HashMap<>();

        int rank = 0;
        for(int num : sortNums) {
            if(!hm.containsKey(num)) {
                hm.put(num, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            sb.append(hm.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
