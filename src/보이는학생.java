import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 보이는학생 {
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
        int answer = 1;
        int h = inputs.get(0);

        for(int i =1; i<n; i++){
            if(inputs.get(i) > h){
                h = inputs.get(i);
                answer++;
            }
        }
        return String.valueOf(answer);
    }
}
