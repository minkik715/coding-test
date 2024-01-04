package need_to_remind;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 공통원소구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> ns = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        int m = Integer.parseInt(br.readLine());
        List<Integer> ms = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        bw.write(solution(n, m ,ns ,ms));
        bw.flush();
        bw.close();
    }

    private static String solution(int n, int m, List<Integer> ns, List<Integer> ms) {
        int p1 =0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 <n && p2< m){
            int n1 = ns.get(p1);
            int m1 = ms.get(p2);

            if(n1 == m1){
                sb.append(n1).append(" ");
                p1++;
                p2++;
            }else if(n1 < m1){
                p1++;
            }else{
                p2++;
            }

        }

        return sb.toString();
    }
}
