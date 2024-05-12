import java.io.*;
import java.util.List;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        bw.write(solution(input.toCharArray()));
        bw.flush();
        bw.close();

    }

    private static String solution(char[] charArray) {
        int check = 0;
        int sum =0;
        for(int i =0; i< charArray.length; i++){
            if(charArray[i] == '('){
                if(charArray[i+1] == ')'){
                    sum += check;
                    i +=1;
                }else{
                    check++;
                }
            }else{
                check--;
                sum +=1;
            }
        }


        return String.valueOf(sum);
    }
}
