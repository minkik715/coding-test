import java.io.*;

public class 회문문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(solution(input));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(String input) {
        String temp = new StringBuilder(input.toLowerCase()).reverse().toString();
        if(input.toLowerCase().equals(temp)){
            return "YES";
        }else {
            return "NO";
        }
    }
}
