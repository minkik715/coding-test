import java.io.*;

public class 소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(solution(n)));
        bw.flush();
        bw.close();
    }

    private static int solution(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (answer[i] == 0) {
                int temp = 2;
                while (i * temp <= n) {
                    answer[i * temp] = 1;
                    temp += 1;
                }
            }
        }
        int rAnswer = 0;
        for (int i = 0; i < n + 1; i++) {
            if (answer[i] == 0) {
                rAnswer += 1;
            }
        }
        return rAnswer;

    }
}
