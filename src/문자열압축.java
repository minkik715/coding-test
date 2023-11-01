import java.io.*;
import java.util.ArrayList;

public class 문자열압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(solution(input));
        bw.flush();
        bw.close();

    }

    private static String solution(String str) {

        StringBuilder sb =new StringBuilder();
        char start = str.charAt(0);
        char[] chars = str.toCharArray();
        int temp =1;
        for(int i =1; i<str.length(); i++){
           if(chars[i] == start){
               temp +=1;
           }else{
               sb.append(start);
               if(temp !=1){
                   sb.append(temp);
               }
               temp = 1;
           }
           start = chars[i];
        }
        sb.append(start);
        if(temp !=1){
            sb.append(temp);
        }

        return sb.toString();
    }
}
