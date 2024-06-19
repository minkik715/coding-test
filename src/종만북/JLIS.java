package 종만북;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JLIS {

    static int[][] cache;

    static int aSize;
    static int bSize;
    static int[] aArr;
    static int[] bArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        for (int t = 0; t < c; t++) {
            String[] s = br.readLine().split(" ");
            aSize = Integer.parseInt(s[0]);
            bSize = Integer.parseInt(s[1]);
            aArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            cache = new int[aSize][bSize];
            for (int i = 0; i < aSize; i++) {
                Arrays.fill(cache[i], 2);
            }
            int max = -1;
            for (int aTemp = 0; aTemp < aSize; aTemp++) {

            }


            bw.write(max + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
/*
    static int jLis(int aIndex, int bIndex) {
        int ret = cache[aIndex][bIndex];
        if (ret != -1) return ret;

        ret = 2;
        long a = aArr[aIndex];
        long b = bArr[bIndex];
        long maxElement = Math.max(a, b);

        for (int nextA = aIndex + 1; nextA < aSize; nextA++) {
            if (maxElement < aArr[nextA]) {
                ret = Math.max(ret, jLis(nextA, bIndex) + 1);
            }
        }

        for (int nextB = aIndex + 1; nextB < aSize; nextB++) {
            if (maxElement < bArr[nextB]) {
                ret = Math.max(ret, jLis(nextB, bIndex) + 1);
            }
        }
    }*/
}
