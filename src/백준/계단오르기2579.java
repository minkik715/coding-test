package 백준;

import java.io.*;

public class 계단오르기2579 {

    static int[] stairs;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        stairs = new int[n];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[] dy = new int[n];

        int answer;
        if (n == 1) {
            answer = stairs[0];
        } else if (n == 2) {
            answer = stairs[0] + stairs[1];
        } else {
            dy[0] = stairs[0];
            dy[1] = stairs[0] + stairs[1];
            dy[2] = Math.max(stairs[0], stairs[1])+ stairs[2];
            for (int i = 3; i < n; i++) {
                dy[i] = Math.max(dy[i - 2], dy[i - 3] + stairs[i - 1]) + stairs[i];
            }
            answer = dy[n - 1];
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
