import java.io.*;
import java.util.ArrayDeque;

public class 교육과정설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        String order = br.readLine();
        String subjects = br.readLine();
        bw.write(solution(order, subjects));
        bw.flush();
        bw.close();
    }

    private static String solution(String orders, String subjects) {

        ArrayDeque<Character> orderQueue = new ArrayDeque<>();
        for (Character order : orders.toCharArray()) {
            orderQueue.add(order);
        }

        for (Character subject : subjects.toCharArray()) {
            if(orderQueue.isEmpty()){
                return "YES";
            }
            if(orderQueue.peek().equals(subject)){
                orderQueue.poll();
            }
        }
        if(orderQueue.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }

}
