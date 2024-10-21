package 백준;

import java.io.*;
import java.util.Arrays;

public class 웰컴키트30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cnts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] inputs = br.readLine().split(" ");
        int tShirts = Integer.parseInt(inputs[0]);
        int pencils = Integer.parseInt(inputs[1]);

        int tShirtsAnswer = 0;
        int pencilAnswer = n/pencils;
        int individualPencinlAnswer= n%pencils;
        for(int i =0; i < cnts.length; i++){
            if(cnts[i]% tShirts ==0){
                tShirtsAnswer += cnts[i]/ tShirts;
            }else{
                tShirtsAnswer += (cnts[i]/ tShirts +1);
            }
        }
        bw.write(tShirtsAnswer+"\n");
        bw.write(pencilAnswer+" "+individualPencinlAnswer+"\n");
        bw.flush();
        bw.close();
    }
}
