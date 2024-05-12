import java.util.*;

public class 문자찾기 {
    public static int solution(String str, char target){
        int answer = 0;
        target = Character.toLowerCase(target);
        for(char c : str.toLowerCase().toCharArray()){
            if(String.valueOf(c).equals(target)){
                answer +=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        char input2 = scanner.next().charAt(0);
        System.out.println(solution(input1, input2));
    }

}
