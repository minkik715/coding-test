// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;
class Main {
    static int[][] board;
    static int n;
    static int[][] mv = {
        {1, 0, 1, 0, 0},
        {1, 0, 1, 1, 2},


    };
    static int[][] mv1 = {
        {0, 1, 0 ,1, 1},
        {0, 1, 1 ,1, 2},
    };
    static int[][] mv2 ={
                {1, 1, 1, 0, 0},
        {1, 1, 0, 1, 1},
        {1, 1, 1, 1, 2}
    };
    static class XY{
        int x1;
        int x2;
        int y1;
        int y2;
        XY(int x1,int y1,int x2,int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2= x2;
            this.y2 = y2;
        }

        void move(int x1,int y1,int x2,int y2){
            this.x1 += x1;
            this.y1 += y1;
            this.x2 += x2;
            this.y2 += y2;
        }

        public boolean check(int status){
            if(x1 >=n || x2 >=n || y1 >=n || y2 >=n){

                return false;
            }
            if(status ==0){
                if(board[y2][x2] ==1){
                    return false;
                }
            }else if(status ==1){
                if(board[y2][x2] ==1){
                    return false;
                }
            }else{
                if(board[y2][x2] ==1 || board[y1][x2] ==1 || board[y2][x1] ==1){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i =0; i<n; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        bw.write(DFS(0, new XY(0,0,1,0)) + "");
        bw.flush();
        bw.close();
        br.close();
        //0: -
        //1: |
        //2: \
    }
    static int DFS(int status, XY xy){


        int sum = 0;
        if(xy.x2 == n-1 && xy.y2 == n-1){
            return 1;
        }else{
            if(status ==0){
                for(int i =0; i<2; i++){
                    int x1 = mv[i][0];
                    int y1 = mv[i][1];
                    int x2 = mv[i][2];
                    int y2 = mv[i][3];
                    int s = mv[i][4];
                    xy.move(x1, y1, x2, y2);
                    if(xy.check(s)){
                        sum += DFS(s, xy);
                    }

                    xy.move(-x1, -y1, -x2, -y2);

                }

            }else if(status ==1){
                for(int i =0; i<2; i++){
                    int x1 = mv1[i][0];
                    int y1 = mv1[i][1];
                    int x2 = mv1[i][2];
                    int y2 = mv1[i][3];
                    int s = mv1[i][4];
                    xy.move(x1, y1, x2, y2);
                    if(xy.check(s)){
                        sum += DFS(s, xy);
                    }
                    xy.move(-x1, -y1, -x2, -y2);

                }
            }else if(status==2){
                for(int i =0; i<3; i++){
                    int x1 = mv2[i][0];
                    int y1 = mv2[i][1];
                    int x2 = mv2[i][2];
                    int y2 = mv2[i][3];
                    int s = mv2[i][4];
                    xy.move(x1, y1, x2, y2);
                    if(xy.check(s)){
                        sum+= DFS(s, xy);
                    }
                    xy.move(-x1, -y1, -x2, -y2);
                }
            }
            return sum;
        }
    }
}