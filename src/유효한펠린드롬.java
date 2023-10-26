import java.io.*;

public class 유효한펠린드롬 {
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
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        String cp = sb.toString().toLowerCase();
        String temp = new StringBuilder(cp.toLowerCase()).reverse().toString();
        if (cp.equals(temp)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
