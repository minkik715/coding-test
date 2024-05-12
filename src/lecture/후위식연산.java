import java.io.*;
import java.util.Stack;

public class 후위식연산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(solution(input));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(String input) {
        Stack<Integer> numStack = new Stack<>();
        for (Character c : input.toCharArray()) {
            if(c.equals('+')){

                numStack.push(numStack.pop() + numStack.pop());
            }else if(c.equals('-')){
                Integer back = numStack.pop();
                Integer front = numStack.pop();
                numStack.push(front - back);
            }else if(c.equals('*')){
                numStack.push(numStack.pop() * numStack.pop());
            }else if(c.equals('/')){
                Integer back = numStack.pop();
                Integer front = numStack.pop();
                numStack.push(front / back);
            }else{
                numStack.push(Integer.parseInt(c.toString()));
            }
        };
        return numStack.pop().toString();
    }
}
