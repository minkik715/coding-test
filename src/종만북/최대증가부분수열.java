package 종만북;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 최대증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        for (int t = 0; t < c; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            List<Integer> cache = new ArrayList<>(Collections.nCopies(n, 1));

            int max = -1;
            for (int i = 1; i < arr.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (arr.get(i) > arr.get(j)) {
                        cache.set(i, Math.max(cache.get(i), cache.get(j) + 1));
                        max = Math.max(max, cache.get(i));
                    }
                }
            }
            bw.write(max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
