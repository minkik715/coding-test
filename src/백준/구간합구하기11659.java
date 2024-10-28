package 백준;

import java.io.*;

public class 구간합구하기11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n+1];
        String[] split = br.readLine().split(" ");
        for(int i =0; i<split.length; i++){
            arr[i+1]  = Integer.parseInt(split[i]);
        }

        int[] sum = new int[n+1];
        sum[1] = arr[1];
        for (int i = 2; i < n+1; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            String[] sections = br.readLine().split(" ");
            int start = Integer.parseInt(sections[0]);
            int end = Integer.parseInt(sections[1]);
            bw.write((sum[end] - sum[start - 1]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
