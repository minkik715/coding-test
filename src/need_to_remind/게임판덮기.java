package need_to_remind;

import java.io.*;

public class 게임판덮기 {

    static int[][][] move = new int[][][]{
            {{1, 0}, {0, 1}},
            {{1, 0}, {1, 1}},
            {{0, 1}, {1, 1}},
            {{-1, 1}, {0, 1}}
    };

    static int y;
    static int x;

    static String[][] matrix;

    static int needToFill;

    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        for (int t = 0; t < total; t++) {
            String[] s = br.readLine().split(" ");
            y = Integer.parseInt(s[0]);
            x = Integer.parseInt(s[1]);
            matrix = new String[y][x];
            answer = 0;
            needToFill =0;
            for (int i = 0; i < y; i++) {
                matrix[i] = br.readLine().split("");
            }

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (matrix[i][j].equals(".")) {
                        needToFill++;
                    }
                }
            }
            BFS();

            bw.write(String.valueOf(answer) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void BFS() {
        if (needToFill == 0) {
            answer++;
            return;
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (matrix[i][j].equals(".")) {
                    for (int t = 0; t < 4; t++) {
                        int[][] xy = move[t];
                        int tempx = xy[0][0] + j;
                        int tempy = xy[0][1] + i;
                        int tempx2 = xy[1][0] + j;
                        int tempy2 = xy[1][1] + i;
                        if (pointCheck(tempx, tempy) && pointCheck(tempx2, tempy2)) {
                            matrix[tempy][tempx] = "#";
                            matrix[tempy2][tempx2] = "#";
                            matrix[i][j] = "#";
                            needToFill -= 3;
                            BFS();
                            needToFill += 3;
                            matrix[tempy][tempx] = ".";
                            matrix[i][j] = ".";
                            matrix[tempy2][tempx2] = ".";
                        }
                    }
                    return;
                }
            }
        }
    }


    private static boolean pointCheck(int pointX, int pointY) {
        return pointX >= 0 && pointX <= x - 1
                && pointY >= 0 && pointY <= y - 1 &&
                matrix[pointY][pointX].equals(".");
    }
}
