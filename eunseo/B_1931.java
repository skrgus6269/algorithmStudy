import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 문제: 회의실 배정
 * 메모리: 42520 kb
 * 시간: 444 ms
 * 풀이: 그리디 사용
 */
public class B_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}
		
		// 끝나는 시간을 기준으로 오름차순 정렬
		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) { // 끝나는 시간이 같으면 시작 시간이 빠른 순으로
					return o1[0]-o2[0];
				} else { // 끝나는 시간이 빠른 순으로
					return o1[1]-o2[1];
				}
			}
		});
		
		int result = 0;
		int end = 0; // 이전 회의의 종료 시간
		for(int i = 0; i < N; i++) {
			if(meetings[i][0]>=end) {
				end = meetings[i][1];
				result++;
			}
		}
		
		System.out.println(result);
	}
}
