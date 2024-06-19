package 종만북;

import java.io.*;

public class 비대칭타일링 {

    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(asyncTiling(n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    public static int asyncTiling(int size) {
        int dp[] = new int[101];
        long answer = tiling(dp, size);
        if(size < 2){
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if ((size % 2) == 0) {
            answer -= (dp[size / 2] + dp[(size / 2) - 1]);
            answer += (2 * MOD);
        } else {
            answer -= dp[(size - 1) / 2];
            answer += MOD;
        }
        answer %= MOD;

        return (int) answer;
    }

    public static int tiling(int[] dp, int size) {

        if (size <= 1) {
            return 1;
        }

        int ret = dp[size];
        if (ret != 0) {
            return ret;
        }

        ret = (tiling(dp, size - 1) + tiling(dp, size - 2)) % MOD;
        dp[size] = ret;
        return ret;
    }
}
