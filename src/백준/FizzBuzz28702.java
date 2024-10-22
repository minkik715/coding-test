package 백준;

import java.io.*;

public class FizzBuzz28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();
        int answer = 0;
        if (!first.startsWith("Fizz") && !first.equals("Buzz")) {
            answer = Integer.parseInt(first) + 3;
        } else if (!second.startsWith("Fizz") && !second.equals("Buzz")) {
            answer = Integer.parseInt(second) + 2;
        } else if (!third.startsWith("Fizz") && !third.equals("Buzz")) {
            answer = Integer.parseInt(third) + 1;
        }


        String strAnswer = "";
        if (answer % 3 == 0) {
            strAnswer = (answer % 5 == 0) ? "FizzBuzz" : "Fizz";
            System.out.println(strAnswer +"@");
        } else if (answer % 5 == 0) {
            strAnswer = "Buzz";
        } else strAnswer = String.valueOf(answer);

        bw.write(strAnswer);
        bw.flush();
        bw.close();
        br.close();
    }
}
