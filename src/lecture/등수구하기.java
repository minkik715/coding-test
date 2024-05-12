import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 등수구하기 {
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
        List<Integer> copy = new ArrayList<>(inputs);
        HashMap<Integer, Integer> map = new HashMap<>();
        inputs.sort(Collections.reverseOrder());
        for (int i = 0; i < input; i++) {
            Integer num = inputs.get(i);
            int finalI = i+1;
            map.putIfAbsent(num, (finalI));
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : copy) {
            sb.append(map.get(integer)).append(" ");
        }
        return sb.toString();
    }
}
