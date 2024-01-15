package need_to_remind;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class K번쨰큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        bw.write(solution(numbers, n, k));
        bw.flush();
        bw.close();

    }

    private static String solution(ArrayList<Integer> numbers, int n, int k) {
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n - 2; i++) {
            int lt = numbers.get(i);
            for (int j = i + 1; j < n - 1; j++) {
                int mt = numbers.get(j);
                for (int l = j + 1; l < n; l++) {
                    int rt = numbers.get(l);
                    set.add(lt+mt+rt);
                }
            }
        }
        Integer kNum = -1;
        int i = 1;
        for (Integer num : set) {
            if(i ==k){
                kNum = num;
                break;
            }
            i++;
        }
        return kNum.toString();
    }
}
