import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 크레인인형뽑기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        Integer n = Integer.parseInt(br.readLine());
        int[][] arrs = new int[n][n];

        List<Stack<Integer>> stackList = new ArrayList<>();
        for(int i =0; i<n; i++){
            stackList.add(new Stack<>());
        }

        for(int i =0; i<n; i++){
            String[] inputs = br.readLine().split(" ");
            for(int j =0; j<n; j++){
                int number = Integer.parseInt(inputs[j]);
                arrs[j][n-i-1] = number;
            }
        }
        Integer k = Integer.parseInt(br.readLine());
        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for(int i =0; i<n; i++){
            Stack<Integer> stack = stackList.get(i);
            for(int j=0; j<n; j++){
                int doll = arrs[i][j];
                if(doll != 0){
                    stack.add(doll);
                }
            }
        }

        bw.write(solution(stackList, k, numbers));
        bw.flush();
        bw.close();
        br.close();

    }

    private static String solution(List<Stack<Integer>> stackList, Integer k, List<Integer> numbers) {
        Stack<Integer> answer = new Stack<>();
        Integer result = 0;
        for(int i =0; i<k; i++){
            Integer point = numbers.get(i)-1;
            Stack<Integer> stack = stackList.get(point);
            if(stack.isEmpty()){
                continue;
            }
            Integer data = stack.pop();

            Integer peek = null;
            if(!answer.isEmpty()){
                peek= answer.peek();
            }
            if (peek != null && peek.equals(data)) {
                answer.pop();
                result+=2;
            } else {
                answer.push(data);
            }
        }
        return result.toString();
    }

}
