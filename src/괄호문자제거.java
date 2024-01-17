import java.io.*;

public class 괄호문자제거 {
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
        StringBuilder sb = new StringBuilder();
        for (Character c : input.toCharArray()) {
            if(c.equals('('))       {
                lt++;
            }else if(c.equals(')')){
                lt--;
            }else{
                if(lt ==0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
