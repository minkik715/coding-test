import java.util.*;
import java.io.*;


class Main {
    static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        f = new int[n+1];
        int[] ts = new int[n+1];

        for(int i =1; i<=n; i++){
            f[i] = i;
        }
        input = br.readLine().split(" ");
        for(int i =1; i<input.length; i++){
            ts[Integer.parseInt(input[i])] = 1;
        }

        int[][] party = new int[m][n+1];

        for(int i =0; i<m; i++){
            input = br.readLine().split(" ");
            int bc = -1;
            for(int j= 1; j<input.length; j++){
                int c = Integer.parseInt(input[j]);
                if(bc != -1){
                    union(c, bc);
                }
                party[i][c] = 1;
                bc = c;
            }
        }
        for(int i =1; i<=n; i++){
            if(ts[i] == 1){
                for(int j =1; j<=n; j++){
                    if(find(i) == find(j)){
                        ts[j] = 1;
                    }
                }
            }
        }
        int answer = 0;
        for(int i =0; i<m; i++){
            Boolean lie = true;
            for(int j=1; j<=n; j++){
                if(party[i][j] == 1 && ts[find(j)] ==1 ){
                    lie = false;
                    break;
                }
            }
            if(lie){
                answer++;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int a){
        if(f[a] == a){
            return a;
        }
        int p = find(f[a]);
        f[a] = p;
        return p;

    }

    public static  void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            f[rootA] = rootB;
        }
    }
}