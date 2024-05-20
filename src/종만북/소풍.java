package 종만북;

import java.io.*;

class 소풍 {

    static class StudentPair{
        int first;
        int second;
        StudentPair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static int[] check;
    static StudentPair[] pairs;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int to = Integer.parseInt(br.readLine());
        for(int t =0; t<to; t++){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            answer = 0;
            check = new int[n];
            pairs =new StudentPair[m];
            String[] pairInput = br.readLine().split(" ");
            for(int i =0; i<m; i++){
                pairs[i] = new StudentPair(Integer.parseInt(pairInput[i*2]), Integer.parseInt(pairInput[i*2+1]));
            }
            DFS( 0, 0);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }



    static void DFS(int depth, int idx){
        if(depth== check.length/2){
            answer++;
            return;
        }
        if(idx > pairs.length-1){return;}
        StudentPair pair = pairs[idx];
        if ( check[pair.first] ==0 && check[pair.second] ==0 ) {
            check[pair.first] = 1;
            check[pair.second] =1;
            DFS(depth+1, idx+1);
            check[pair.first] = 0;
            check[pair.second] =0;
        }
        DFS( depth, idx+1);
    }
}
