package 종만북;

import java.util.HashMap;

public class leet2 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));


    }
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        String str = "";
        int answer = 0;
        for(int current =0; current<s.length(); current++){
            String tmp = String.valueOf(s.charAt(current));
            if(!str.contains(tmp)){
                str += tmp;
                answer = Math.max(current-start+1, answer);
            }else{
                answer = Math.max(current-start, answer);
                for(int i=0; i<str.length(); i++){
                    if(String.valueOf(str.charAt(i)).equals(tmp)){
                        start += i+1;
                        str = s.substring(start, current+1);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
