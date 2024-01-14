import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 모든아나그램찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String checkString = br.readLine();
        String word = br.readLine();
        bw.write(solution(checkString, word));
        bw.flush();
        bw.close();
    }

    private static String solution(String checkString, String word) {
        char[] checkArrays = checkString.toCharArray();
        int size = word.length();
        Integer answer = 0;
        Map<Character, Integer> check = new HashMap<>();

        Map<Character, Integer> ttemp = new HashMap<>();
        for (char c : word.toCharArray()) {
            Integer value2 = ttemp.compute(c, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
            ttemp.put(c, value2);
        }
        //b a c a A a c b a
        //0 1 2 3 4 5 6 7 8
        for(int i =0; i<size; i++){
            Character charKey = checkArrays[i];

            Integer sizeValue = check.compute(charKey, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
            check.put(charKey, sizeValue);
        }

        if(checker(ttemp, check)){
            answer++;
        }

        for(int i =size; i<checkArrays.length; i++){
            Character lt = checkArrays[i-size];

            Integer ltValue = check.compute(lt, (key, value) -> {
                if (value == null || value == 1) {
                    return null;
                } else {
                    return value - 1;
                }
            });

            if(ltValue == null){
                check.remove(lt);
            }else {
                check.put(lt, ltValue);
            }


            Character rt = checkArrays[i];

            Integer rtValue = check.compute(rt, (key, value)-> {
                if( value ==null){
                    return 1;
                }else{
                    return value +1;
                }
            });

            check.put(rt, rtValue);

            if(checker(ttemp, check)){
                answer++;
            }
        }
        return answer.toString();
    }


    public static boolean checker(Map<Character, Integer> ttemp, Map<Character, Integer> checker){
        boolean answer = true;

        for (char c : ttemp.keySet()) {
            if (!ttemp.get(c).equals(checker.get(c))) {
                return false;
            }
        }
        return true;
    }
}
