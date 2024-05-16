package 종만북;

import java.io.*;
import java.util.Arrays;

public class 록페스티벌 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int costSize = Integer.parseInt(s[0]);
            int teamSize = Integer.parseInt(s[1]);
            int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(String.format("%.12f",solution(costs, teamSize)) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static Double solution(int[] costs, int team) {
        double min = Double.MAX_VALUE;

        for (int start = 0; start < costs.length; start++) {
            double sum = 0;
            for (int target = start; target < costs.length; target++) {
                sum += costs[target];
                int cnt = target - start +1;
                if(cnt >= team){
                    min = Math.min(min, sum/ cnt);
                }
            }
        }
        return min;
    }

    //오답 ... break의 문제 애초에 잘못됨
    /*private static Double solution(int[] costs, int team) {
        Double min = Double.MAX_VALUE;

        for (int start = 0; start < costs.length; start++) {
            double sum = 0;
            int cnt = 0;
            double avg = Double.MAX_VALUE;
            for (int target = start; target < costs.length; target++) {
                if (cnt++ < team || avg > (sum + costs[target]) / cnt) {
                    sum += costs[target];
                    avg = sum / cnt;
                } else {
                    min = Math.min(min, avg);
                    break;
                }
            }
        }
        return min;
    }*/
}