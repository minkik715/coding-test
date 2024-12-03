package 백준;

import java.io.*;
import java.util.*;

public class 치킨배달15686 {

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int answer = Integer.MAX_VALUE;
    static int m;
    static int n;
    static ArrayList<Pair> home = new ArrayList<>();
    static ArrayList<Pair> chickens = new ArrayList<>();
    static int[][] map;


    static Queue<Pair> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][n];


        for (int y = 0; y < n; y++) {
            map[y] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 1) {
                    home.add(new Pair(x, y));
                } else if (map[y][x] == 2) {
                    chickens.add(new Pair(x, y));
                }
            }
        }
        DFS(new ArrayList<Pair>(), 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void DFS(List<Pair> chicks, int start) {
        if(chicks.size() ==m){
            BFS(chicks);
            return;
        }

        for(int i = start; i<chickens.size(); i++){
            chicks.add(chickens.get(i));
            DFS(chicks, i+1);
            chicks.remove(chicks.size()-1);
        }
    }

    public static void BFS(List<Pair> chicks){
        int sum = 0;
        for(Pair h: home){
            int check = Integer.MAX_VALUE;
            for(Pair chick: chicks){
                check = Math.min(check, Math.abs(h.x-chick.x) + Math.abs(h.y - chick.y));
            }
            sum += check;
        }
        answer = Math.min(answer, sum);
    }

}
