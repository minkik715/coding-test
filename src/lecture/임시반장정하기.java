import java.io.*;
import java.util.Arrays;
import java.util.List;

public class 임시반장정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arrs = new int[n][5];
        for (int i = 0; i < n; i++) {
            int[] arr = new int[5];
            int j = 0;
            for (String str : br.readLine().split(" ")) {
                arr[j++] = Integer.parseInt(str);
            }
            arrs[i] = arr;
        }
        bw.write(solution(n, arrs));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(int n, int[][] arrs) {
        int[] answer = new int[n];
        int[][] check = new int[n+1][n+1];
        for(int i=0; i<5; i++){
            for(int j=0; j<n-1; j++){
                int temp = arrs[j][i];
                for(int k =j+1; k<n; k++){
                    if(temp == arrs[k][i] && check[k][j] == 0){
                        answer[j] = answer[j] +1;
                        answer[k] = answer[k] +1;
                        check[k][j] =1;
                        check[j][k] =1;
                    }
                }
            }
        }
        int max = Arrays.stream(answer).max().getAsInt();
        String answerStr = "";
        for(int i=0; i<n; i++){
            if(answer[i]==max){
                answerStr =  String.valueOf(i + 1);
                break;
            }
        }
        return answerStr;
    }

}
