// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] upDp = new int[n];
        int[] downDp = new int[n];

        Arrays.fill(upDp, 1);
        Arrays.fill(downDp, 1);
        int answer =1;
        for(int i =1; i<n; i++){
            int v= arr[i];
            for(int j= i-1;  j>=0; j--){
                if(v > arr[j]){
                    upDp[i] = Math.max(upDp[i], upDp[j] +1);
                }

            }
        }
        for(int i = n-2; i>=0; i--){
            int v = arr[i];
            for(int j= i+1; j<n; j++){
                if(v > arr[j]){
                    downDp[i] = Math.max(downDp[i], downDp[j] +1);
                }
            }
        }

        for(int i =0; i<n; i++){
            answer = Math.max(answer, upDp[i] + downDp[i]);
        }
        bw.write(answer-1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}