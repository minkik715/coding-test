import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 기억이안나 {
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
        // 100 90 90 89
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> sorted = inputs.stream().sorted().collect(Collectors.toList());
        for (int i = input - 1; i >= 0; i--) {
            Integer num = sorted.get(i);
            int finalI = i;
            map.computeIfAbsent(num, (key) -> (input - finalI));
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : inputs) {
            sb.append(map.get(integer)).append(" ");
        }
        return sb.toString();
    }
}
