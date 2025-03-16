// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

class Main {

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
        int answer = 0;
        for(int i =0; i<m; i++){
            if(board[0][i] ==1){
                answer = 1;
                break;
            }
        }
        for(int i =0; i<n; i++){
            if(board[i][0] ==1){
                answer = 1;
                break;
            }
        }

        for(int i =1; i<n; i++){
            for(int j =1; j<m; j++){
                if(board[i][j] != 0){
                    int a = board[i-1][j-1];
                    int b = board[i-1][j];
                    int c = board[i][j-1];
                    if(a == 0 || b== 0 || c == 0){
                        continue;
                    }
                    board[i][j] = Math.min(a, Math.min(b,c)) +1;
                    answer = Math.max(Math.max(1,answer), board[i][j]);
                }

            }
        }
        bw.write(answer * answer + "");
        bw.flush();
        bw.close();
        br.close();

    }



}