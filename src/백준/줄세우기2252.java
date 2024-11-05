package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 줄세우기2252 {
    static List<Integer> dfsOrder = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();
    static int[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<Integer> bigs = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            dfs.add(new ArrayList<>());
        }


        check = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int big = Integer.parseInt(input2[0]);
            int small = Integer.parseInt(input2[1]);
            dfs.get(big).add(small);
            bigs.add(big);
        }
        for (Integer big : bigs) {
            DFS(big);
        }
        Collections.reverse(dfsOrder);

        for (Integer number : dfsOrder) {
            bw.write(number + " ");
        }
        for (int i = 1; i < n + 1; i++) {
            if (check[i] == 0) bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int big) {
        if (check[big] != 0) return;
        for (Integer small : dfs.get(big)) {
            DFS(small);
        }
        check[big] = 1;
        dfsOrder.add(big);
    }
}
