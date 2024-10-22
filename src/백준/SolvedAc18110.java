package 백준;

import java.io.*;
import java.util.Arrays;

public class SolvedAc18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] hardPoints = new int[n];
        for (int i = 0; i < n; i++) {
            hardPoints[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(hardPoints);
        int remove = (int) Math.round(n * 0.15);
        if(remove*2 >= n) remove=0;
        int points = 0;
        for(int i = remove; i<n-remove; i++){
            points += hardPoints[i];
        }

        int answer = (int) Math.round((double) points/(n-(remove*2)));
        bw.write(answer+ "");
        bw.flush();
        bw.close();
        br.close();
    }
}
