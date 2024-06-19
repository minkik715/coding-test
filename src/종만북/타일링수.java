package 종만북;

import java.io.*;

public class 타일링수 {


    static int[] cache = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(tiling(Integer.parseInt(br.readLine()))+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

    public static int tiling(int width){
        if(width <= 1) return 1;

        int ret = cache[width];
        if(ret != 0){
            return ret;
        }

        ret = (tiling(width - 1) + tiling(width - 2)) % 1000000007;
        cache[width] = ret;
        return ret;
    }
}
