import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 랜선 자르기
 * 메모리: 14524 kb
 * 시간: 124 ms
 * 풀이: 이분탐색 응용
 */
public class B_1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];
        long max = 0;
        for(int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if(max < lan[i]) {
                max = lan[i];
            }
        }

//        Arrays.sort(lan);   // 이렇게 구한 값에 lan[K-1]+1 해준뒤 저장하면 오버플로우가 남
        max++;  // 랜선의 길이가 모두 1일 경우

        // long으로 해줘야함
        long min = 0;
        long mid = 0;

        long count = 0;
        while(min < max) {
            mid = (min + max)/2;

            count = 0;
            for(int i = 0; i < K; i++) {
                count += lan[i]/mid;
            }

            if(count < N) {
                max = mid;
            } else{
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }
}
