import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 중복확인 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> collect = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
        String answer = null;
        if(collect.size() == n){
            answer ="U";
        }else {
            answer = "D";
        }
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
