package 백준;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class 연구소 {

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int X;
    static int Y;

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};

    static ArrayList<Pair> virus = new ArrayList<>();

    static ArrayList<Pair> empty = new ArrayList<>();

    static Queue<Pair> q = new ArrayDeque<>();

    static int[][] map;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        map = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            int[] xs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = xs;
            for (int j = 0; j < X; j++) {
                if (xs[j] == 2) {
                    virus.add(new Pair(j, i));
                } else if (xs[j] == 0) {
                    empty.add(new Pair(j, i));
                }
            }
        }
        DFS(0, new ArrayList<>());
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int level, ArrayList<Pair> candidate) {
        if (candidate.size() == 3) {
            BFS(new ArrayList<>(candidate));
            return;
        }

        for (int i = level; i < empty.size(); i++) {
            candidate.add(empty.get(i));
            DFS(i + 1, candidate);
            candidate.remove(candidate.size() - 1);
        }
    }

    static void BFS(ArrayList<Pair> candidate) {
        int[][] clearMap = new int[Y][X];

        for(int i=0; i<Y; i++){
            for(int j=0; j<X; j++){
                clearMap[i][j] = map[i][j];
            }
        }
        int[][] visited = new int[Y][X];
        for (Pair p : candidate) {
            clearMap[p.y][p.x] = 1;
            visited[p.y][p.x] = 1;
        }
        for (Pair v : virus) {
            q.offer(v);
        }
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int x = current.x;
            int y = current.y;

            int here = clearMap[y][x];
            if (here == 0) {
                clearMap[y][x] = 2;
            } else if (here == 1) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int newX = x + moveX[i];
                int newY = y + moveY[i];
                if (!(newX < 0 || newX > X - 1 || newY < 0 || newY > Y - 1 || visited[newY][newX] == 1 || clearMap[newY][newX] == 1)) {
                    visited[newY][newX] = 1;
                    q.add(new Pair(newX, newY));
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<Y; i++){
            for(int j=0; j<X; j++){
                if(clearMap[i][j] ==0){
                    cnt++;
                }
            }
        }
        max = Math.max(cnt,max);
    }
}
