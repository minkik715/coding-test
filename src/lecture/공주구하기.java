import java.io.*;
import java.util.ArrayDeque;

public class 공주구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int mans = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        bw.write(solution(mans, k));
        bw.flush();
        bw.close();
    }

    private static String solution(int mans, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i =1; i<=mans; i++){
            queue.add(i);
        }

        int temp =1;
        while (queue.size() != 1){
            Integer num = queue.pop();
            if(temp == k){
                temp = 1;
            }else{
                temp +=1;
                queue.add(num);
            }
        }

        return String.valueOf(queue.pop());
    }
}
