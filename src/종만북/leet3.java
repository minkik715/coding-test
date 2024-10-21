package 종만북;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class leet3 {
    public static void main(String[] args) {


        class Solution {

            List<String> answer = new ArrayList<>();
            HashMap<String, String> map = new HashMap();

            ArrayList<String> converts = new ArrayList<>();

            public List<String> letterCombinations(String digits) {
                if (digits.isEmpty()) return Collections.emptyList();

                map.put("2", "abc");
                map.put("3", "def");
                map.put("4", "ghi");
                map.put("5", "jkl");
                map.put("6", "mno");
                map.put("7", "pqrs");
                map.put("8", "tuv");
                map.put("9", "wxyz");

                ArrayList<String> converts = new ArrayList<>();
                String[] numbers = digits.split("");


                for (int i = 0; i < digits.length(); i++) {
                    converts.add(map.get(String.valueOf(numbers[i])));
                }
                DFS(0, "");
                for (String s : answer) {
                    System.out.println(s);
                }
                return answer;
            }

            void DFS(int level, String t) {
                if (level == converts.size()) {
                    answer.add(t);
                    return;
                }
                char[] values = converts.get(level).toCharArray();

                for (int i = 0; i < values.length; i++) {
                    DFS(level + 1, t + values[i]);
                }
            }
        }
    }
}
