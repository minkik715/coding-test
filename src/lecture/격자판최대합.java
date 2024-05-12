import java.io.*;

public class 격자판최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arrs = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] arr = new int[n];
            int j = 0;
            for (String str : br.readLine().split(" ")) {
                arr[j++] = Integer.parseInt(str);
            }
            arrs[i] = arr;
        }
        bw.write(solution(n, arrs));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(int n, int[][] arrs) {
        int max = -1;
        int crossTemp =0;
        int crossTemp2 =0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            int temp2 = 0;
            for (int j = 0; j < n; j++) {
                temp += arrs[i][j];
                temp2 += arrs[j][i];
            }
            crossTemp += arrs[i][i];
            crossTemp2 += arrs[i][n-i-1];
            max = Math.max(temp2, Math.max(max, temp));
        }
        max = Math.max(crossTemp2, Math.max(max, crossTemp));

        return String.valueOf(max);
    }

}
