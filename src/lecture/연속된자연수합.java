import java.io.*;

public class 연속된자연수합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(solution(n));
        bw.flush();
        bw.close();
    }

    private static String solution(int n) {
        int answer = 0;
        int sum =0;
        int rt = 1;
        int lt = rt;
        while (lt <n/2 +1){
            if(sum ==n){
                sum -= lt++;
                answer ++;
            } else if (sum < n){
                sum += rt++;
            }else{
                sum -= lt++;
            }
        }
        return String.valueOf(answer);
    }
}
