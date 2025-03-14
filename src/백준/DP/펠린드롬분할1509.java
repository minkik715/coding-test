// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        for(int i=0; i<n; i++){
            pal[i][i] = true;
        }
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                pal[i][i+1] = true;
            }
        }

        for(int i =2; i<n; i++){
            for(int j =0; i+j <n; j++){
                if(s.charAt(j) == s.charAt(i+j) && pal[j+1][i+j-1]){
                    pal[j][i+j] = true;
                }
            }
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i= 1; i<=n; i++){
            for(int j = i; j<=n; j++){
                if(pal[i-1][j-1]){
                    dp[j] = Math.min(dp[i-1] +1, dp[j]);
                }
            }
        }
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}