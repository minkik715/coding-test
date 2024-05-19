package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class 연속합1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bw.write(String.valueOf(solution(n, numbers)));
        bw.close();
        br.close();
    }

    private static int solution(int n, int[] numbers){
        int[] answers = new int[n];
        answers[0] = numbers[0];
        for(int i =1; i<n; i++){
            int sum = answers[i-1];
            if(sum < 0){
                sum = 0;
            }
            int number = numbers[i];
            answers[i] = Math.max(number, number+sum);
        }
        int answer = answers[0];
        for(int i =1; i< n; i++){
            answer = Math.max(answers[i], answer);
        }

        return answer;
    }
}
