package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 문제: 센서 (B2212)
 * 풀이: 그리디
 * 메모리: 16408kb
 * 시간: 180ms
 */
public class B2212 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 센서들을 오름차순으로 정렬한다.
        Arrays.sort(sensors);

        // 오름차순으로 정렬한 센서들끼리의 거리를 구한다.
        Integer[] sensorDiff = new Integer[N - 1];
        for (int i = 0; i < N - 1; i++) {
            sensorDiff[i] = sensors[i + 1] - sensors[i];
        }

        // 센서들 사이의 거리에 대해 내림 차순으로 정렬한다.
        Arrays.sort(sensorDiff, Comparator.reverseOrder());

        // 집중국 수신 가능한 영역의 길이의 합의 최솟값은,
        // 집중국 사이의 거리가 최대가되는 경우를 제외한 값들의 합이다.
        // 즉, N-1 개의 센서들 사이의 거리가 있을때
        // 센서들 사이가 가장 먼 순으로 K-1 을 선택했을때 이를 제외한
        // 나머지들의 합이 집중국 수신 가능한 영역의 길이의 합의 최솟값이 된다.
        int result = 0;
        for (int i = K - 1; i < N - 1; i++) {
            result += sensorDiff[i];
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2212().solution();
//    }
//}
