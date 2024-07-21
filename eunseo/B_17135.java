import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: 캐슬 디펜스
 * 메모리: 13056 kb
 * 시간: 144 ms
 * 풀이: 구현(시뮬레이션) - 메서드 분리, 단계별 구현 계획 수립
 */
public class B_17135 {
	static int N, M, D, R = 3;
	static int[] numbers;
	static int[][] map;
	static int[][] kill;
	static int result;
	static int[][] killList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		numbers = new int[R];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(result);
	}

	private static void comb(int cnt, int start) {
		if(cnt==R) {
			kill = new int[N][M];
			killList = new int[][]{{-1,-1},{-1,-1},{-1,-1}};	// 궁수 3명의 x,y
			for(int c = N; c>0; c--) {
				for(int i = 0; i < R; i++) {
					attack(numbers[i], c, i);
				}
//				for(int i = 0; i < 3; i++) {
//					for(int j = 0; j < 2; j++) {
//						if(killList[i][j]==-1) continue;
//					}
//				}
				for(int i = 0; i < 3; i++) {
					if(killList[i][0]==-1 || killList[i][1]==-1) continue;
					
					kill[killList[i][0]][killList[i][1]] = 1;
				}
			}
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					sum+=kill[i][j];
				}
			}
			if(sum>result) {
				result = sum;
			}
			return ;
		}
		for (int i = start; i < M; i++) {
			numbers[cnt]=i;
			comb(cnt+1, i+1);
		}
	}

	private static void attack(int archerY, int x, int num) {
		int min = Integer.MAX_VALUE;
		int minX=0, minY=0;
		int plus = 0;
		int check = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==1 && kill[i][j]!=1) {
					int distance = Math.abs(x-i)+Math.abs(archerY-j);
					if(distance<=D && min>=distance) {
						if(min==distance) {
							if(check<j) {
								continue;
							}
						}
						min = distance;
						minX = i;
						minY = j;
//						killList[num][0] = i;
//						killList[num][1] = j;
						plus++;
						check = j;
					}
				}
			}
		}
		if(plus!=0) {
			killList[num][0] = minX;
			killList[num][1] = minY;
//			kill[minX][minY] = 1;	
//			killList[num][0];
		}
		
	}
}
