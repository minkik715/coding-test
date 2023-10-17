import java.util.*;


public class 대소문자변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(solution(input));
        return;
    }

    public static String solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }

}
