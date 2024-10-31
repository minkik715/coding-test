package 백준;

import java.io.*;
import java.util.Arrays;

public class A123더하기9095 {

    static int[] cache = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Arrays.fill(cache, -1);
        for(int i =0; i<n; i++){
            int number = Integer.parseInt(br.readLine());
            bw.write(DFS(number)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    public static int DFS(int number){
        int sum = 0;
        if(number ==0){
            return 1;
        }else if(number <0){
            return 0;
        }else{

            if(cache[number] != -1){
                return cache[number];
            }

            for(int i =1; i<=3; i++){
                sum += DFS(number-i);
            }
            cache[number] = sum;
        }
        return sum;
    }
}
