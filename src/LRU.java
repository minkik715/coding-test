import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int cacheSize = Integer.parseInt(inputs[0]);
        int jobSize = Integer.parseInt(inputs[0]);
        List<Integer> jobs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        bw.write(solution(cacheSize, jobSize, jobs));
        bw.flush();
        bw.close();
    }

    private static String solution(int cacheSize, int jobSize, List<Integer> jobs) {
        List<Integer> cache = new ArrayList<>(cacheSize);
        for (int i = 0; i < cacheSize; i++) {
            cache.add(0);
        }


        for (Integer job : jobs) {
            int cacheLoc = cache.indexOf(job);
            if (cacheLoc != -1) {
                for (int i = cacheLoc; i >0 ; i--) {
                    cache.set(i , cache.get(i-1));
                }
            } else {
                for (int i = cacheSize - 1; i >0 ; i--) {
                    cache.set(i, cache.get(i-1));
                }
            }
            cache.set(0, job);
        }

        StringBuilder sb =new StringBuilder();
        for (Integer i : cache) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
