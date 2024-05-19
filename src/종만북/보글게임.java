package 종만북;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class 보글게임 {

    private static String[][] matrix;
    private static Boolean fullName = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s = Integer.parseInt(br.readLine());

        for (int q = 0; q < s; q++) {
            matrix = new String[5][5];
            for (int i = 0; i < 5; i++) {
                matrix[i] = br.readLine().split("");
            }

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String find = br.readLine();
                fullName = false;
                bw.write(find + " " + solution(find) + "\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static String solution(String find) {
        String[] findSplit = find.split("");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j].equals(findSplit[0])) {
                    int x = j;
                    int y = i;
                    if (findNear(x, y, find.substring(1))) {
                        return "YES";
                    }
                    ;
                }
            }
        }
        return "NO";
    }


    public static Boolean findNear(int x, int y, String find) {
        int[] xs = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] ys = {-1, -1, -1, 0, 0, 1, 1, 1};
        boolean isFind = false;
        for (int i = 0; i < 8; i++) {
            int tempX = x + xs[i];
            int tempY = y + ys[i];

            if (tempX < 0 || tempX > 4 || tempY < 0 || tempY > 4) {
                continue;
            }

            if (matrix[tempY][tempX].equals(find.split("")[0])) {
                String next = "";
                if (find.length() > 1) next = find.substring(1);
                if (next.isEmpty()) return true;
                isFind = findNear(tempX, tempY, next);
                if (isFind) return true;
            }
        }
        return isFind;
    }

    static class Loc {
        int x;
        int y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
