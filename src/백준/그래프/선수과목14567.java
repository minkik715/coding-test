// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] answer = new int[n+1];
        int[][] store = new int[n+1][n+1];
        int[] indegrees = new int[n+1];



        for(int i =0; i<m; i++){
            input = br.readLine().split(" ");

            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            store[second][first] = 1;
            indegrees[second] = indegrees[second] +1;
        }


        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i =1; i<=n; i++){
            if(indegrees[i] ==0){
                indegrees[i] = -1;
                answer[i] = 1;
                q.offer(i);
            }
        }


        while(!q.isEmpty()){
            int s = q.poll();
            for(int i =1; i<=n; i++){
                if(store[i][s] ==1){
                    indegrees[i] = indegrees[i] -1;
                }
            }
            for(int i =1; i<=n; i++){

                if(indegrees[i] ==0){
                    indegrees[i] = -1;
                    answer[i] = answer[s]+1;
                    q.offer(i);
                }
            }
        }

        for(int i =1; i<=n; i++){
            bw.write(answer[i] +" ");
        }
        bw.flush();
        bw.close();
        br.close();


    }
}