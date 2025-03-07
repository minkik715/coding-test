// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int answer = 0;
        for(int i =1; i<=s1.length(); i++){
            char c1 =  s1.charAt(i-1);

            for(int j=1; j<=s2.length(); j++){
                char c2 = s2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] +1;
                    answer = Math.max(answer, dp[i][j]);
                }else{
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}