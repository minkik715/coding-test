package 종만북;

import java.io.*;
import java.util.Arrays;

public class 시계맞추기 {

    static int[] numbers;
    static int answer;

    static int[] answerChecker = new int[]{12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    static int[][] switches = new int[][]{
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };
    static int realAnswer =Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i ++){
            numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            answer = 0;
            realAnswer = Integer.MAX_VALUE;
            DFS( 0);
            if(realAnswer == Integer.MAX_VALUE){
                bw.write(-1 +"\n");
            }else{
                bw.write(realAnswer + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    private static void DFS(int depth) {
        if(Arrays.equals(answerChecker, numbers)){
            realAnswer = Math.min(realAnswer, answer);
            return;
        }

        if (depth == 10) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            for (int sw : switches[depth]) {
                int temp = numbers[sw];
                if (temp == 12) {
                    temp = 0;
                }
                numbers[sw] = temp + 3;
            }
            answer += (i+1)%4;
            DFS(depth +1);
            answer -= (i+1)%4;
        }
    }
}
