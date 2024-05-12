import java.io.*;

public class 문장속단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        br.close();


        bw.write(solution(inputs));
        bw.flush();
        bw.close();
    }

    public static String solution(String[] inputs){
        String answer = "";
        int cnt = 0;
        for (String s : inputs){
            int sLength = s.length();
            if( cnt < sLength){
                cnt = sLength;
                answer = s;
            }
        }
        return answer;
    }
}
