// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] input= br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        ArrayList<Integer> answer = new ArrayList<>();
        while(l <=100){

            int a = n/l - (l-1)/2;
            if(a<0){
                l++;
                continue;
            }
            int sum = l*(2 *a + (l-1))/2;
            if(sum == n){
                for(int i=0; i<l; i++){
                    answer.add(a+i);
                }
                break;
            }
            l++;
        }
        if(answer.size() ==0){
            bw.write("-1");
        }else{
            for(Integer i : answer){
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}