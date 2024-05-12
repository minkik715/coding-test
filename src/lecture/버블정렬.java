import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 버블정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        List<Integer> nums = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        bw.write(solution(nums));
        bw.flush();

    }

    private static String solution(List<Integer> nums) {
        int size = nums.size();
        int lp, min;
        for (int i = 0; i < size-1; i++) {
            lp = nums.get(i);
            min = lp;
            for (int j = i + 1; j < size; j++) {
                int rp = nums.get(j);
                if(min > rp){
                    nums.set(j, min);
                    min = rp;
                    nums.set(i, min);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(Integer num :nums){
            sb.append(num).append(" ");
        }
        return sb.toString();
    }
}
