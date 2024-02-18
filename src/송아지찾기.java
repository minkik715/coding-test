import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 송아지찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        Integer start = Integer.valueOf(temp[0]);
        Integer target = Integer.valueOf(temp[1]);
        bw.write(solution(start, target));
        bw.flush();
        bw.close();
    }

    private static String solution(Integer start, Integer target) {

        Queue<LocTree> locTrees = new ArrayDeque<>();

        LocTree parent = new LocTree(0,
                start
        );
        int[] check = new int[10001];
        locTrees.add(parent);
        String answer = "";
        while (!locTrees.isEmpty()){
            LocTree locTree = locTrees.poll();
            if(locTree.loc == target){
                answer = String.valueOf(locTree.count);
                break;
            }else{
                int minus1 = locTree.loc - 1;
                int plus1 = locTree.loc + 1;
                int plus5 = locTree.loc + 5;

                if(minus1 >= 1 && check[minus1] ==0){
                    locTrees.add(new LocTree(
                            locTree.count+1,
                            minus1
                    ));
                    check[minus1] =1;
                }
                if(plus1 < 10001 &&check[plus1] ==0){
                    locTrees.add(new LocTree(
                            locTree.count+1,
                            plus1
                    ));
                    check[plus1] =1;
                }
                if(plus5 < 10001 && check[plus5] ==0){
                    locTrees.add(new LocTree(
                            locTree.count+1,
                            plus5
                    ));
                    check[plus5] =1;
                }



            }
        }
        return answer;
    }

    public static class LocTree {
        int count;

        int loc;

        LocTree(int count, int loc) {
            this.count = count;
            this.loc = loc;
        }
    }
}
