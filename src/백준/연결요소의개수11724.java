package 백준;

import java.io.*;
import java.util.HashSet;

public class 연결요소의개수11724 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        arr = new int[n+1];
        arr[0] = -1;
        for(int i =1; i<n+1; i++){
            arr[i] = i;
        }

        for(int i =0; i<m; i++){
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            merge(u,v);
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i =1; i<n+1; i++){
            hashSet.add(find(i));
        }
        bw.write(hashSet.size()+"");
        bw.flush();
        bw.close();
        br.close();

    }

    public static void merge(int u, int v){
        int uParent = find(u);
        int vParent = find(v);
        if(uParent == vParent) return;

        if(uParent> vParent){
            arr[vParent] = uParent;
        }else{
            arr[uParent] = vParent;
        }
    }

    public static int find(int node){
        int value = arr[node];
        if(value == node){
            return node;
        }else{
            int root = find(value);
            arr[node] = root;
            return root;
        }
    }
}
