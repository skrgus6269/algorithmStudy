import java.util.*;

/**
 * 문제: Z
 * 메모리: 12864 kb
 * 시간: 96 ms
 * 풀이: 분할정복, 재귀 활용
 */
public class B_1074 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int size = (int) Math.pow(2, N);

        cut(r,c,size);
        System.out.println(count);
    }

    private static void cut(int r, int c, int size) {
        if(size == 1) return;

        if(r < (size/2) && c < (size/2)) {  // 왼쪽 위
            cut(r, c, size/2);
        } else if(r < (size/2) && c >= (size/2)) {   // 오른쪽 위
            count += ((size*size)/4)*1;
            cut(r, c-(size/2), size/2);
        } else if(r >= (size/2) && c < (size/2)) {   // 왼쪽 아래
            count += ((size*size)/4)*2;
            cut(r-(size/2), c, size/2);
        } else {    // (r >= (size/2) && c >= (size/2))     // 오른쪽 아래
            count += ((size*size)/4)*3;
            cut(r-(size/2), c-(size/2), size/2);
        }
    }
}
