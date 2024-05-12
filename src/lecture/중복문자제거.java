import java.io.*;
import java.util.HashMap;

public class 중복문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        bw.write(solution(input));
        br.close();
        bw.flush();
        bw.close();
    }

    private static String solution(String input) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(Character c : input.toCharArray()){
            if(hashMap.get(c) == null){
                answer.append(c);
                hashMap.put(c, 1);
            }
        }
        return answer.toString();
    }

}
