// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] store = new int[n];
        store = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int i =0;
        int j = n-1;
        int min =0;
        int max = 0;
        int gap = Integer.MAX_VALUE;
        while(i <j){
            int lv = store[i];
            int rv = store[j];
            int v= Math.abs(lv + rv);
            if(v <gap){
                min = lv;
                max = rv;
                gap =v ;
            }
            if(gap == 0){
                break;
            }
            if(Math.abs(lv) > Math.abs(rv)){
                if(lv <0){
                    i++;
                }else{
                    j--;
                }
            }else{
                j--;
            }
        }
        bw.write(min + " " +max);
        bw.flush();
        bw.close();
        br.close();
    }
}