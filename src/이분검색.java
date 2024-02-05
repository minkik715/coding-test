import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 이분검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int target = Integer.parseInt(s[1]);

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(list);
        bw.write(solution(target, list, n));
        bw.flush();
        bw.close();
    }

    private static String solution(int target, List<Integer> list, int size) {
        int lt = 0;
        int rt = size - 1;
        int answer = -1;
        while (lt <= rt) {
            int middle = (lt + rt) / 2;
            Integer point = list.get(middle);
            if(point == target){
                answer = middle;
                break;
            }else if (point > target){
                rt = middle;
            }else {
                lt = middle;
            }
        }
        return String.valueOf(answer +1);
    }
}
