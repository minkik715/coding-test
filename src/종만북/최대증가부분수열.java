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
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n= arr.length;
        choices = new int[n];

        bw.write(myLis(c) + "\n");
        bw.flush();
        bw.close();
        br.close();

        /* for (int t = 0; t < c; t++) {
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
        }*/
    }
    static int[] choices;

    static int[] cache = new int[101];
    static int n;

    static int arr[] = new int[100];
/*    public static int lis(int start){
        int ret = cache[start+1];
        if(ret != 0) return ret;


        int bestNext = -1;
        for(int next = start+1; next<n; next++){
            if(start == -1 || arr[start] < arr[next]){
                int cand = lis(next) +1;
                if(cand > lis){
                    bestNext = next;
                }
            }
        }
    }*/

    static public int myLis(int start){
        int ret = cache[start];
        if(ret != 0) return ret;

        ret = 1;
        int bestNext = -1;
        for(int i = start+1; i<n; i++){
            int nowNumber = arr[start];
            if(nowNumber < arr[i]){
                int candi = myLis(i) + 1;
                if(candi > ret){
                    ret = candi;
                    bestNext = i;
                }

            }
        }

        choices[start] = bestNext;
        cache[start] = ret;
        return ret;
    }



}
