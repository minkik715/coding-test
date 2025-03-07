// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;


class Main {


    static int[] nums;
    static int[] nodes;
    static int[] maxNodes;
    static Pair[] pairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        nums = new int[n+1];
        nodes = new int[4*n +1];
        maxNodes = new int[4*n +1];
        pairs = new Pair[m];
        for(int i = 1; i<=n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i =0; i<m; i++){
            input = br.readLine().split(" ");

            pairs[i] = new Pair(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        init(1, n, 1);
        init2(1, n, 1);
        for(int i =0; i<m; i++){
            Pair pair = pairs[i];
            bw.write(
                    query(1,n,pair.first, pair.second,1) +" "
            );
            bw.write(
                    query2(1,n,pair.first, pair.second,1) +"\n"
            );
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static int init(int left, int right, int node){
        if(left == right){
            return nodes[node] = nums[left];
        }
        if(left > right){
            return Integer.MAX_VALUE;
        }
        int mid = (left + right) /2;
        return nodes[node] =  Math.min(init(left, mid, node*2), init(mid+1, right, node*2 +1)
        );
    }

    public static int query(int left, int right, int targetLeft, int targetRight, int node){
        if(targetLeft > right || targetRight < left) {
            return Integer.MAX_VALUE;
        }
        if(targetLeft <=left && targetRight >= right){
            return nodes[node];
        }

        int mid = (left+right)/2;
        return Math.min(
                query(left, mid, targetLeft, targetRight, 2*node),
                query(mid+1, right, targetLeft, targetRight, 2*node+1)
        );
    }

    public static int init2(int left, int right, int node){
        if(left == right){
            return maxNodes[node] = nums[left];
        }
        if(left > right){
            return Integer.MIN_VALUE;
        }
        int mid = (left + right) /2;
        return maxNodes[node] =  Math.max(init2(left, mid, node*2), init2(mid+1, right, node*2 +1)
        );
    }

    public static int query2(int left, int right, int targetLeft, int targetRight, int node){
        if(targetLeft > right || targetRight < left) {
            return Integer.MIN_VALUE;
        }
        if(targetLeft <=left && targetRight >= right){
            return maxNodes[node];
        }

        int mid = (left+right)/2;
        return Math.max(
                query2(left, mid, targetLeft, targetRight, 2*node),
                query2(mid+1, right, targetLeft, targetRight, 2*node+1)
        );
    }

    static class Pair{
        int first;
        int second;

        Pair(int f, int s){
            this.first = f;
            this.second =s;
        }
    }


}