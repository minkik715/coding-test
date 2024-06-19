package 종만북;

import java.io.*;

public class 폴리오미노 {
    static final long MOD = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        for(int i=0; i<c; i++){
            int size = Integer.parseInt(br.readLine());
            bw.write(merge(size) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static long merge(int size){
        long answer = 0;
        long[][] dp = new long[size+1][size+1];
        for(int i =1; i<=size; i++){
            answer += polinomio(i, size-i, dp);
        }
        return answer%MOD;
    }

    public static long polinomio(int first, int remain, long[][] dp){
        if(dp[first][remain] != 0){
            return dp[first][remain];
        }
        if(remain == 0){
            return 1;
        }

        long result = 0;
        for(int second = 1; second<=remain; second++){
            long tmp = first + second -1;
            tmp *=  polinomio( second, remain-second, dp);
            tmp %=MOD;
            result +=tmp;
            result %=MOD;
        }

        dp[first][remain] = result;
        return result;
    }
}
