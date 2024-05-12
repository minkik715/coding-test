import java.io.*;
import java.util.Objects;

public class 뒤집은소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[]  as = br.readLine().split(" ");

        bw.write(solution(n, as));
        bw.flush();
        bw.close();
        br.close();
    }

    //가위 1 바위 2 보3
    private static String solution(int n, String[] numbers) {
        int[] sosus = new int[1000001];
        sosus[1] = 1;
        for(int i =2; i<= Math.sqrt(1000000); i++){
            for(int j =i*2; j<= 1000000; j+=i){
                sosus[j] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            Integer num = Integer.valueOf(new StringBuilder(number).reverse().toString());
            if(sosus[num]==0){
                sb.append(num).append(" ");
            }
        }
        return sb.toString();
    }

}
