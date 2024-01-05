import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs = br.readLine().split(" ");
        int size = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        bw.write(solution(size, target, numbers));
        bw.flush();
        bw.close();
    }

    private static String solution(int size, int target, ArrayList<Integer> numbers) {
        int start = 0;
        int answer = 0;
        int sum = numbers.get(0);
        int i=0;
        while (i< size){

            if(sum == target){
                answer++;
                if(i == size-1){
                    break;
                }
                sum -= numbers.get(start++);
                sum += numbers.get(++i);
            }else if(sum > target){
                sum -= numbers.get(start++);
            }else{
                if(i == size-1){
                    break;
                }
                sum += numbers.get(++i);
            }
        }
        return String.valueOf(answer);
    }
}
