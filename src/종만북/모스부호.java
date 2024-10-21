package 종만북;

import java.io.*;

public class 모스부호 {

    static int skip;

    static int[][] bino= new int[201][201];

    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<200; i++){
            bino[i][0] =1;
            bino[i][i] =1;
            for(int j=1; j<i; j++){
                bino[i][j] = Math.min(bino[i - 1][j - 1] + bino[i - 1][j],1000000100);
            }
        }

        for(int c=0; c<t; c++){
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            skip = Integer.parseInt(inputs[2]) -1;

            generate(n, m, "");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }



    public static void generate(int n, int m , String s){
        if(skip < 0) return;

        if(n ==0 && m ==0){
            if(skip ==0){
                sb.append(s).append("\n");
            }
            skip--;
            return;
        }

        if(bino[n+m][n] <= skip){
            skip -= bino[n+m][n];
            return;
        }

        if(n >0) {
            generate(n-1, m, s + "-" );
        }
        if(m >0){
            generate(n, m-1, s + "o");
        }
    }
}
