package 종만북;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> rus = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> kor = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            Collections.sort(rus);
            Collections.sort(kor);

            int wins = 0;
            int lowest = 0;
            for(int i =0; i<n; i++){
                if(kor.get(i) >= rus.get(lowest)){
                    lowest++;
                    wins++;
                }
            }
            bw.write(wins + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
