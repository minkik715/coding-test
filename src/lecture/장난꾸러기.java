import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 장난꾸러기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        bw.write(solution(n, inputs));
        bw.flush();
        bw.close();
    }

    private static String solution(int n, List<Integer> inputs) {
        int bigFriend = 0;
        int smallFriend = 0;
        for(int i =0; i<n-1; i++){
            if(inputs.get(i) > inputs.get(i+1)){
                bigFriend = i+1;
                break;
            }
        }
        int temp = inputs.get(bigFriend - 1);
        int tempNum = bigFriend-1;
        while (temp == inputs.get(tempNum)){
            tempNum--;
        }
        bigFriend = tempNum+2;


        for(int i =n-1; i>0; i--){
            if(inputs.get(i) < inputs.get(i-1)){
                smallFriend = i +1;
                break;
            }
        }
        return bigFriend + " " + smallFriend;
    }
}
