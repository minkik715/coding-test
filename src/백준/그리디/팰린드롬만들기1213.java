// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] ap = new int[26];
        int n =s.length();
        for(int i =0; i<n; i++){
            ap[s.charAt(i) - 65] += 1;
        }
        int check = 0;
        for(int i =0; i<26; i++){
            if(! (ap[i] %2 ==0)){
                check++;
            }
        }

        String t = "";
        String answer= "";
        if(check > 1){
            answer = "I'm Sorry Hansoo";
        }else{
            for(int i =0; i< 26; i++){
                char c = (char) (65 + i);
                if(! (ap[i] %2 ==0)){
                    t = String.valueOf(c);
                }
                for(int j=0; j< ap[i]/2; j++){
                    answer += c;
                }
            }
            answer = answer + t + (new StringBuilder(answer)).reverse();

        }
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}