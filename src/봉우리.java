import java.io.*;

public class 봉우리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arrs = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            int[] arr = new int[n + 2];
            int j = 1;
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
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int target = arrs[i][j];
                if (target > arrs[i - 1][j] && target > arrs[i][j - 1] && target > arrs[i][j + 1] && target > arrs[i + 1][j]) {
                    answer += 1;
                }

            }
        }
        return String.valueOf(answer);
    }

}
