package 백준;

import java.io.*;
import java.util.Arrays;

public class 평범한배낭 {

    static int maxWeight;
    static int n;
    static int[] weights;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        maxWeight = Integer.parseInt(s[1]);
        weights = new int[n];
        values = new int[n];
        int[] dy = new int[maxWeight+1];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            weights[i] = Integer.parseInt(s1[0]);
            values[i] = Integer.parseInt(s1[1]);
        }
        for(int i=0; i<n; i++){
            int nowWeight = weights[i];
            int nowValue = values[i];
            for(int j=maxWeight; j>=nowWeight; j--){
                dy[j] = Math.max(dy[j], dy[j-nowWeight] + nowValue);
            }
        }

        bw.write(String.valueOf(Arrays.stream(dy).max().getAsInt()));



        bw.flush();
        bw.close();
        br.close();
    }

}
