package need_to_remind;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 최대길이연속부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int size = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        bw.write(solution(size, n, numbers));
        bw.flush();
        bw.close();
    }

    private static String solution(int size, int n, ArrayList<Integer> numbers) {

        int temp =0;
        int lt = 0;
        int rt = 0;
        int cnt =0;
        int max = 0;
        while (rt <size){
            int number = numbers.get(rt);
            if(number ==1){
                cnt++;
                rt++;
                max = Math.max(cnt, max);
            }else{
                if(temp == n){
                    int l = numbers.get(lt);
                    if(l ==0){
                        lt++;
                        temp--;
                        cnt--;
                    }else{
                        cnt--;
                        lt++;
                    }
                }else{
                    temp++;
                    cnt++;
                    rt++;
                    max = Math.max(cnt, max);
                }
            }
        }
        return String.valueOf(max);
    }
}
