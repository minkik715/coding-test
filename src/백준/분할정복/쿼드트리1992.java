// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;

class Main {
    static String[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        for(int i =0; i<n; i++){
            board[i] = br.readLine().split("");
        }
        bw.write(DFS(n, n, n));
        bw.flush();
        bw.close();
        br.close();

    }

    static String DFS(int n, int x, int y){

        if(n == 1){
             return board[y-1][x-1];

        }
             String a = DFS(n/2, x-n/2, y-n/2);
             String b = DFS(n/2, x, y-n/2);
             String c = DFS(n/2, x-n/2, y);
             String d = DFS(n/2, x, y);


        if(a.equals("0") && b.equals("0") && c.equals("0") && d.equals("0")){
            return "0";
        }
        if(a.equals("1") && b.equals("1") && c.equals("1") && d.equals("1")){
            return "1";
        }
        return ("(" + a + b + c + d + ")") ;
    }

}