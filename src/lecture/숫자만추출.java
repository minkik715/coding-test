import java.io.*;

public class 숫자만추출 {
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
        return String.valueOf(Integer.parseInt(input.replaceAll("[^0-9]", "")));
    }
}
