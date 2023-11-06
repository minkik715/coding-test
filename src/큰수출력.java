import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 큰수출력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        bw.write(solution(n, inputs));
        bw.flush();
        bw.close();
    }

    private static String solution(int n , List<Integer> inputs) {
        StringBuilder sb = new StringBuilder();
        sb.append(inputs.get(0)).append(" ");
        for(int i =1; i<n; i++){
            if(inputs.get(i) > inputs.get(i-1)){
                sb.append(inputs.get(i)).append(" ");
            }
        }
        return sb.toString();
    }
}
