package 종만북;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class 도시락데우기 {

    public static class Lunch{
        int heatTime;
        int eatTime;
        Lunch(int heatTime, int eatTime){
            this.eatTime = eatTime;
            this.heatTime =heatTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> heat = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> eat = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            ArrayList<Lunch> lunches = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                lunches.add(new Lunch(heat.get(i), eat.get(i)));
            }

            lunches.sort(new Comparator<Lunch>() {
                @Override
                public int compare(Lunch o1, Lunch o2) {
                    if (o2.eatTime > o1.eatTime) {
                        return 1;
                    } else if (o2.eatTime < o1.eatTime) {
                        return -1;
                    }
                    return 0;
                }
            });

            int heatTime = 0;
            int eatTime = 0;
            for (int i = 0; i < n; i++) {
                heatTime += lunches.get(i).heatTime;
                eatTime = Math.max(eatTime, heatTime + lunches.get(i).eatTime);
            }
            bw.write(eatTime+ "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}
