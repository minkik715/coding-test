import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        bw.write(solution(input, inputs));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(Integer input, List<Integer> inputs) {
        int answer = 0;
        int plusScore = 0;
        for (int i = 0; i < input; i++) {
            if (inputs.get(i) == 1) {
                answer += 1;
                answer += plusScore;
                plusScore += 1;
            } else {
                plusScore = 0;
            }
        }
        return String.valueOf(answer);
    }
}
