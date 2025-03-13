// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][n];
        int[][] store = new int[n+1][n+1];
        for(int i =0; i<n; i++){
            input = br.readLine().split(" ");

            for(int j =0; j<n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
                if(j == 0){
                    store[i+1][j+1] = arr[i][j];
                }else{
                    store[i+1][j+1] = store[i+1][j] + arr[i][j];
                }
            }
        }
        for(int i =0; i<m; i++){
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int answer = 0;
                for(int y=x1; y<=x2; y++){
                    answer += store[y][y2] - store[y][y1-1];
                }
            bw.write(answer + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}