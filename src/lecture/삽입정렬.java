import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 삽입정렬 {
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
        for(int i =1; i<size; i++){
            int rt = nums.get(i);
            int j = i-1;
            while(j>=0 && nums.get(j) >= rt){
                nums.set(j+1,nums.get(j));
                j--;
            }
            nums.set(j+1,rt);
        }
        StringBuffer sb = new StringBuffer();
        for(Integer num :nums){
            sb.append(num).append(" ");
        }
        return sb.toString();
    }
}
