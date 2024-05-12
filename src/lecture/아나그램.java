import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        bw.write(solution(str1, str2));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(String str1, String str2) {
        Map<Character, Integer> first = new HashMap();
        Map<Character, Integer> second = new HashMap();
        char[] firstArray = str1.toCharArray();
        char[] secondArray = str2.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            Character f = firstArray[i];
            Character s = secondArray[i];

            Integer i1 = first.get(f);
            if(i1 == null){
                first.put(f, 1);
            }else{
                first.put(f, i1+1);
            }
            Integer i2 = second.get(s);

            if(i2 == null){
                second.put(s, 1);
            }else{
                second.put(s, i2+1);
            }
        }
        String answer ="YES";
        for (Character key : first.keySet()) {
            if (!first.get(key).equals(second.get(key))) {
                return "NO";
            }
        }
        return "YES";
    }
}
