package 종만북;

import java.io.*;
import java.util.Arrays;

public class 삼각형위의최대경로 {

    static int arr[][];

    static int n;

    static int cache[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());

        for(int t =0; t<c; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            cache = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.fill(cache[i], -1);
            }
            bw.write(maxSearch(0, 0)+ "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int maxSearch(int x, int y) {
        if (y == n - 1) {
            return arr[y][x];
        }

        int ret = cache[y][x];

        if (ret != -1) {
            return ret;
        }


        ret = Math.max(maxSearch( x,y + 1), maxSearch(x + 1, y + 1)) + arr[y][x];
        cache[y][x] = ret;
        return ret;
    }
}
