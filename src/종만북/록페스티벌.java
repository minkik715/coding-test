package 종만북;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 록페스티벌 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int costSize = Integer.parseInt(s[0]);
        int teamSize = Integer.parseInt(s[1]);
        int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw.write(String.valueOf(solution(costs, teamSize)));
        bw.flush();
        bw.close();
    }

    private static Float solution(int[] costs, int team) {
        float min = Float.MAX_VALUE;

        for (int start = 0; start < costs.length - 1; start++) {
            float sum = 0;
            int cnt = 0;
            float avg = Float.MAX_VALUE;
            for (int target = start ; target < costs.length; target++) {
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
    }
}
