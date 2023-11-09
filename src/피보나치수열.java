import java.io.*;
import java.util.Objects;

public class 피보나치수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        bw.write(solution(n));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(int n) {
        int[] fibo = new int[n];
        fibo[0] = 1;
        fibo[1] = 1;
        StringBuilder sb =new StringBuilder();
        sb.append(1).append(" ").append("1").append(" ");
        for(int i =2; i<n; i ++){
            int fiboSum = fibo[i - 1] + fibo[i - 2];
            fibo[i] = fiboSum;
            sb.append(fiboSum).append(" ");
        }
        return sb.toString();
    }

}
