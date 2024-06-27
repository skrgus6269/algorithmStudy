import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* Java11 / 14252 KB / 100 ms
*/
public class Main {

    static class Material {
        public int sour;
        public int bitter;

        public Material(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }

    static Material[] materials;
    static int n;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        materials = new Material[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            materials[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        makeFood(0, 0, 1, 0);

        System.out.println(result);
    }

    public static void makeFood(int count, int idx, int sour, int bitter) {
        if (0 < count) {
            result = Math.min(result, Math.abs(sour - bitter)); // 음식 값 비교
        }

        if (result == 0) {
            return;
        }

        if (idx == n) { // 끝까지 돌았을 경우 return
            return;
        }

        makeFood(count, idx + 1, sour, bitter); // 재료 안 넣기
        makeFood(count + 1, idx + 1, sour * materials[idx].sour, bitter + materials[idx].bitter); // 재료 넣기
    }

}
