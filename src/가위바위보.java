import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class 가위바위보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[]  as = br.readLine().split(" ");
        String[] bs = br.readLine().split(" ");

        bw.write(solution(n, as, bs));
        bw.flush();
        bw.close();
        br.close();
    }

    //가위 1 바위 2 보3
    private static String solution(int n, String[]  as, String[]  bs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String a = as[i];
            String b = bs[i];

            if (Objects.equals(a, "1")) {
                if (Objects.equals(b, "1")) {
                    sb.append("D");
                } else if (Objects.equals(b, "2")) {
                    sb.append("B");
                } else {
                    sb.append("A");
                }
            } else if (Objects.equals(a, "2")) {
                if (Objects.equals(b, "1")) {
                    sb.append("A");
                } else if (Objects.equals(b, "2")) {
                    sb.append("D");
                } else {
                    sb.append("B");
                }
            } else {
                if (Objects.equals(b, "1")) {
                    sb.append("B");
                } else if (Objects.equals(b, "2")) {
                    sb.append("A");
                } else {
                    sb.append("D");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
