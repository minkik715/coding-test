package 종만북;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 와일드카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        for(int t=0; t<c; t++){
            String wild = br.readLine();
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> targets = new ArrayList<>();
            for(int i =0; i<n; i++){
                String temp = br.readLine();
                while (temp.contains("**")){
                    temp = temp.replace("**", "*");
                }
                targets.add(temp);
            }
            ArrayList<String> answers = new ArrayList<>();
            for (String target : targets) {
                if( match(wild, target)){
                    answers.add(target);
                }
            }
            Collections.sort(answers);
            for (String answer : answers) {
                bw.write(answer + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }



    private static boolean match(String wild, String target) {
        int i = 0;
        while (
                i < target.length() &&
                        i < wild.length() &&
                        (wild.charAt(i) == '?'||
                        wild.charAt(i) == target.charAt(i))
        ) {
            i++;
        }
        if (wild.length() == i) {
            return i == target.length();
        }
        if (wild.charAt(i) == '*') {
            for (int skip = 0; i + skip <= target.length(); skip++){
                if(match(wild.substring(i +1), target.substring(i +skip))){
                    return true;
                }
            }
        }
        return false;
    }
}
