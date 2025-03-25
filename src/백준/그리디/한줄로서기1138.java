// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i =n-1; i>=0; i--){
            answer.add(arr[i], i+1);
        }

        for(Integer i: answer){
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}