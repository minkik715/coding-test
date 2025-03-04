// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

// 벡터란 방향이다
// 두 좌표의 벡터는 (x2-x1), (y2-y1) 이며
//벡터의 값은 대각선의 두점 사이의 거리라고 볼 수 있다.
//내적은 벡터의 각도를 나타내는 것으로 x1*x2+ y1+y2
// 내적이 양수면 예각 ( 벡터가 같은 방향)
// 내적이 0 이면 90
// 내적이 음수면 둔각 ( 벡터가 다른 방향 )
//벡터 외적은 (x1*y2) - (y2*x1) 으로 벡터의 평행사변형 크기 혹은, 방향을 의미한다.
// 외적이 음수면 시계방향
// 외적이 양수면 반시계방향
// 외적이 0이면 직선이다.
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] x1y1 = br.readLine().split(" ");
        String[] x2y2= br.readLine().split(" ");
        String[] x3y3= br.readLine().split(" ");

        int x1 = Integer.parseInt(x1y1[0]);
        int y1 = Integer.parseInt(x1y1[1]);

        int x2 = Integer.parseInt(x2y2[0]);
        int y2 = Integer.parseInt(x2y2[1]);

        int x3 = Integer.parseInt(x3y3[0]);
        int y3 = Integer.parseInt(x3y3[1]);

        int result = (x2-x1)*(y3-y1) - (x3-x1)*(y2-y1);

        if(result ==0){
            bw.write("0");
        }else if(result> 0){
            bw.write("1");
        }else{
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}