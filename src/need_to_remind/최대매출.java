package need_to_remind;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 최대매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ints = br.readLine().split(" ");
        int n = Integer.parseInt(ints[0]);
        int k = Integer.parseInt(ints[1]);

        ArrayList<Integer> integers = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        bw.write(solution(n, k, integers));
        bw.flush();
        bw.close();
    }

    private static String solution(int n, int k, ArrayList<Integer> incomes) {
        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer += incomes.get(i);
        }
        int checkSum = answer;
        for (int i = 1; i <= n - k; i++) {
            checkSum = checkSum - incomes.get(i-1) + incomes.get(i + k-1);
            answer = Math.max(checkSum, answer);
        }

        return String.valueOf(answer);
    }
}
