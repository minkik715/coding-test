import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 멘토링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int studentCount = Integer.parseInt(temp[0]);
        int examCount = Integer.parseInt(temp[1]);
        int[][] arrs = new int[examCount][studentCount];

        for(int i  =0; i<examCount; i++){
            int[] students = new int[studentCount];
            String[] temp2 = br.readLine().split(" ");
            for(int j=0; j<studentCount; j++){
                students[j] = Integer.parseInt(temp2[j]);
            }
            arrs[i] = students;
        }

        bw.write(solution(arrs, studentCount, examCount));
        bw.flush();
        bw.close();
        br.close();

    }

    private static String solution(int[][] arrs, int studentCount, int examCount) {
        int[][] check = new int[studentCount+1][studentCount+1];
        int answer= 0;
        for(int i =0; i<examCount; i++) {
            for(int j=0; j<studentCount-1; j++){
                int mentor = arrs[i][j];
                for(int k = j+1; k<studentCount; k++){
                    int menti = arrs[i][k];
                    if(check[menti][mentor] ==0 && check[mentor][menti] ==0){
                        check[mentor][menti] =1;
                        answer++;
                    }else if(check[menti][mentor] ==1){
                        check[menti][mentor] =-1;
                        check[mentor][menti] = -1;
                        answer--;
                    }
                }
            }
        }
        return String.valueOf(answer);
    }


}
