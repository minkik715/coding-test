package 종만북;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 문자열합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            Collections.sort(numbers);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (Integer number : numbers) {
                pq.add(number);
            }

            int result = 0;
            while(!pq.isEmpty()){
                int first = pq.poll();
                int second = pq.isEmpty()? 0 : pq.poll();
                int sum = first + second;
                result += sum;
                if(!pq.isEmpty()){
                    pq.add(sum);
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
