// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;


class Main {
    static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        DFS(1, new ArrayList<Integer>());
        for(ArrayList<Integer> a: answer){
            for(Integer num :a){
                bw.write(num + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int t, ArrayList<Integer> l ){
        if(l.size() == m){
            answer.add(new ArrayList<Integer>(l));
        }else{

            for(int i =t; i<=n; i++){
                l.add(i);
                DFS(i, l);
                l.remove(l.size()-1);
            }
        }


    }


}