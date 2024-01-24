import java.io.*;
import java.util.ArrayDeque;


public class 응급실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        Integer n = Integer.parseInt(input[0]);
        Integer m = Integer.parseInt(input[1]);
        String[] inputs = br.readLine().split(" ");
        ArrayDeque<Target> queue = new ArrayDeque();
        for(int i =0; i<n; i++){
            if(i == m){
                queue.add(new Target(Integer.parseInt(inputs[i]), true));
            }else{
                queue.add(new Target(Integer.parseInt(inputs[i]), false));
            }
        }
        bw.write(solution(n,m, queue));
        bw.flush();
        bw.close();

    }

    private static String solution(Integer n, Integer m, ArrayDeque<Target> queue) {
        int order = 1;
        while (true){
            Target pop = queue.pop();
            boolean goBack = queue.stream().anyMatch(
                    t -> t.danger > pop.danger
            );
            if(goBack){
                queue.add(pop);
            }else{
                if(pop.check){
                    break;
                }else{
                    order++;
                }
            }
        }
        return String.valueOf(order);
    }

    public static class Target{
        Integer danger;
        Boolean check;

        Target(Integer danger, Boolean check){
            this.danger = danger;
            this.check = check;
        }
    }
}
