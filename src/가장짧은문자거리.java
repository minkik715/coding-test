import java.io.*;
import java.util.ArrayList;

public class 가장짧은문자거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] t = br.readLine().split(" ");
        String str = t[0];
        String alpha = t[1];

        bw.write(solution(str, alpha));
        bw.flush();
        bw.close();

    }

    private static String solution(String str, String alpha) {
        ArrayList<Integer> alpahIndex = new ArrayList<>();
        char[] chars = str.toCharArray();
        char c = alpha.charAt(0);
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                alpahIndex.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < chars.length; i++) {

            int temp = 101;
            for (int j : alpahIndex) {
                int gap = Math.abs(i - j);
                if(temp > gap) {
                    temp = gap;
                };
            }
            sb.append(temp).append(" ");
        }
        return sb.toString();
    }
}
