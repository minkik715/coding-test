package 종만북;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 초밥 {

    public static class Shushi {

        int price;
        int priority;

        Shushi(int price, int priority) {
            this.price = price;
            this.priority = priority;
        }
    }

    static Shushi[] shushis;
    static int n;

    static int[] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            int totalPrice = Integer.parseInt(input[1]);
            shushis = new Shushi[n];
            for (int i = 0; i < n; i++) {
                String[] sushiInput = br.readLine().split(" ");
                shushis[i] = new Shushi(Integer.parseInt(sushiInput[0]), Integer.parseInt(sushiInput[1]));
            }
            bw.write(shushiGraph(totalPrice) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static int shushiGraph(int totalPrice) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            Shushi shushi = shushis[i];
            if (totalPrice - shushi.price >= 0) {
                ret = Math.max(ret, shushiGraph(totalPrice - shushi.price) + shushi.priority);
            }
        }

        return ret;
    }
}
