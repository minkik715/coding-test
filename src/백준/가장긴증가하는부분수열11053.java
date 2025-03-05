import java.io.*;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dy = new int[n];
        Arrays.fill(dy, 1);

        int max = 1;
        for(int i =1; i<n; i++){
            for(int j=0; j<i; j++){
                if(numbers[i] > numbers[j] ){
                    dy[i] = Math.max(dy[j] +1 , dy[i]);
                    max = Math.max(max, dy[i]);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
