import java.io.*;
import java.util.*;
public class 단어뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> inputs = new ArrayList<>();
        for(int i =0; i<n; i++){
            inputs.add(br.readLine());
        }

        for(String s : solution(inputs)){
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static ArrayList<String> solution(ArrayList<String> inputs) {
        ArrayList<String> answer = new ArrayList<>();
        for(String s : inputs){
            answer.add(new StringBuilder().append(s).reverse().toString());
        }
        return answer;
    }
}
