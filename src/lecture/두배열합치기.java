import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 두배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int firstSize = Integer.parseInt(br.readLine());
        ArrayList<Integer> first = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int secondSize = Integer.parseInt(br.readLine());
        ArrayList<Integer> second = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        bw.write(solution(first, second));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(ArrayList<Integer> first, ArrayList<Integer> second) {
        int p1 = 0;
        int p2 = 0;
        int p1max = first.size();
        int p2max = second.size();
        StringBuilder sb = new StringBuilder();
        while (p1max != p1 || p2max != p2) {
            int i = 101;
            int j = 101;
            if (p1max != p1) {
                i = first.get(p1);
            }
            if (p2max != p2) {
                j = second.get(p2);
            }
            if (i <= j) {
                sb.append(i).append(" ");
                p1++;
            } else {
                sb.append(j).append(" ");
                p2++;
            }
        }
        return sb.toString();
    }
}
