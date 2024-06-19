package 종만북;

import java.io.*;
import java.util.Arrays;

public class 울타리잘라내기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = blocks[0];
        int start = 0;
        for(int i =1; i<n; i++){
            if(blocks[i] > max){
                start = i;
                max = blocks[i];
            }
        }
        int left = start;
        int right = start;
        int width = 1;
        int size = blocks[start] * 1;
        while (left != 0 || right != n - 1) {

            if (left == 0 && right < n - 1) {
                size = Math.max(size, ++width * blocks[++right]);
                continue;
            }

            if (right == n - 1 && left > 0) {
                size = Math.max(size, ++width * blocks[--left]);
                continue;
            }

            if (blocks[right + 1] > blocks[left - 1]) {
                size = Math.max(size, ++width * blocks[++right]);
            } else {
                size = Math.max(size, ++width * blocks[--left]);
            }
        }
        System.out.println(size);

    }
}
