import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 학급회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        bw.write(solution(chars));
        bw.flush();
        bw.close();
    }

    private static String solution(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        String answer ="";
        for (char aChar : chars) {
            Character alphabet = aChar;
            Integer i = map.get(alphabet);
            if(i == null){
                map.put(alphabet, 1);
            }else{
                int num = i + 1;
                map.put(alphabet, num);
                if(max < num){
                    max = num;
                    answer = alphabet.toString();
                }
            }
        }
        return answer;
    }
}
