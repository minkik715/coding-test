package 백준;

import java.io.*;

public class 팩토리얼0의개수1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int tenAnswer =0;
        int twoAnswer = 0;
        int fiveAnswer = 0;
        for(int i =1; i<=n; i++){
            int temp = i;
            while (temp%10 ==0){
                temp /=10;
                tenAnswer++;
            }
            while (temp%5 ==0){
                temp /=5;
                fiveAnswer++;
            }
            while (temp%2 ==0){
                temp /=2;
                twoAnswer++;
            }
        }
        int answer = tenAnswer + Math.min(twoAnswer, fiveAnswer);
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
