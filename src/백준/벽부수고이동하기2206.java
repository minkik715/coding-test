package 백준;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 벽부수고이동하기2206 {

    public static class Pair {
        int x;
        int y;

        int w;

        boolean broken;
        Pair(int x, int y, int w, boolean broken) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.broken = broken;
        }

    }

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int Y = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);
        int[][] map = new int[Y][X];


        for (int i = 0; i < Y; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < X; j++) {
                if (map[i][j] == 1) {
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        boolean possible = false;

        int[][][] visited = new int[Y][X][2];
        Queue<Pair> q = new ArrayDeque<>();

        visited[0][0][0] = 1;
        visited[0][0][1] = 1;
        q.add(new Pair(0, 0, 1, false));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int x = current.x;
            int y = current.y;
            int w = current.w;
            boolean b = current.broken;
            if (x == X - 1 && y == Y - 1) {
                possible = true;
                answer = Math.min(answer, w);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = moveX[i] + x;
                int nextY = moveY[i] + y;
                int nextW = w+1;
                if (nextX >= 0 && nextX < X && nextY >= 0 && nextY < Y) {
                    if(b){
                        if(map[nextY][nextX] == 0){
                            if(visited[nextY][nextX][1] == 0){
                                visited[nextY][nextX][1] =1;
                                q.offer(new Pair(nextX, nextY, nextW, true));
                            }
                        }
                    }else{
                        if(map[nextY][nextX] == 0){
                            if(visited[nextY][nextX][0] == 0){
                                visited[nextY][nextX][0] =1;
                                q.offer(new Pair(nextX, nextY, nextW, false));
                            }
                        }else{
                            if(visited[nextY][nextX][1] == 0){
                                visited[nextY][nextX][1] =1;
                                q.offer(new Pair(nextX, nextY, nextW, true));
                            }
                        }
                    }
                }
            }
        }

        if (!possible) {
            answer = -1;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
