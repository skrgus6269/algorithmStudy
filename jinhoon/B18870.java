package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제: (B18870)
 * 풀이 : 정렬, 맵
 * 1. 배열을 정렬한다
 * 2. 정렬한 배열을 순서대로 맵에 넣어 압축한다.
 * 3. 원래 배열을 순회하면서 맵에 넣어둔 압축된값을 조회 한다.
 * 메모리: 267500kb
 * 시간: 1888ms
 */
public class B18870 {

    public void solution() throws IOException {

        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] sortArr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sortArr[i] = num;
        }
        Arrays.sort(sortArr);
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], count++);
            }
        }

        for (int i = 0; i < N; i++) {
            result.append(map.get(arr[i])).append(" ");
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B18870().solution();
//    }
//}
