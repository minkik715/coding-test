import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 매출액의종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        ArrayList<Integer> incomes = (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        bw.write(solution(n, k, incomes));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(int n, int k, ArrayList<Integer> incomes) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            temp.compute(incomes.get(i), (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }
        answer.append(temp.keySet().size());
        for (int i = k; i < n; i++) {
            Integer lt = incomes.get(i - k);
            Integer ltValue = temp.get(lt);
            if (ltValue == 1) {
                temp.remove(lt);
            } else {
                temp.put(lt, ltValue - 1);
            }

            Integer rt = incomes.get(i);

            temp.compute(rt, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
            answer.append(" ").append(temp.size());
        }
        return answer.toString();
    }
}
