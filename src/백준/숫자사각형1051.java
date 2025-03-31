// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

class Main {

    static class XY{
        int x;
        int y;

        XY(int x, int y){
            this.x =x;
            this.y = y;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] board = new int[n][m];
        for(int i =0; i<n; i++){
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int answer = 1;

        for(int r = 1; r<n; r++){
            for(int y = 0; y+r<n; y++){
                for(int x =0; x+r<m; x++){
                    int v =board[y][x];
                    if(v == board[y][x+r]
                            && v== board[y+r][x]
                            && v == board[y+r][x+r]){
                        answer = (r+1)*(r+1);
                    }
                }
            }
        }


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();




    }
}