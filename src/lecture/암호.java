import java.io.*;

public class 암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String en = br.readLine();

        bw.write(solution(n, en));
        bw.flush();
        bw.close();

    }

    private static String solution(int n, String en) {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = i * 7;
            sb.append(decode(en.substring(temp, temp + 7)));
        }
        return sb.toString();
    }

    private static char decode(String en) {
/*        String temp = en.replace("*", "0");
        String temp2 = temp.replace("#", "1");*/
        char[] chars = en.toCharArray();
        int decode = 0;
        for (int i = 0; i <=6; i++){
            if(chars[i] =='#'){
                decode += Math.pow(2, 6-i);
            }
        }
        return (char) decode;
    }
}
