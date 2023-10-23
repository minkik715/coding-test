import java.util.*;
import java.io.*;

public class 특정문자뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(solution(input));
        bw.flush();
        bw.close();
    }

    public static String solution(String input){
        int size = input.length();
        // 0 1 2 3 4 5 6 7 8 홀수 9 size -1 자기자신
        // 0 1 2 3 4 5 짝수 6 size -1 자기자신
        char[] chars = input.toCharArray();
        char[] answer = chars;
        for(int i =0; i<size/2; i++){
            char lp = chars[i];
            char rp = chars[size-i-1];
            if(Character.isAlphabetic(lp)){
                answer[i] = rp;
            }
            if(Character.isAlphabetic(rp)){
                answer[size-1-i] =lp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char a : answer){
            sb.append(a);
        }
        return sb.toString();
    }
}
