import java.io.*;

public class 올바른괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(solution(input));
        bw.flush();
        bw.close();
    }


    private static String solution(String input) {
        int lt = 0;
        for (Character c : input.toCharArray()) {
            if(c.equals('('))       {
                lt++;
            }else{
                lt--;
            }
            if(lt <0){
                return "NO";
            }
        }
        if(lt ==0){
            return "YES";
        }
        return "NO";
    }
}
