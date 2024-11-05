package 백준;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 장난감조합2637 {

    public static class Toy{
        int needs;
        int number;
        Toy(int number, int needs){
            this.number = number;
            this.needs = needs;
        }
    }

    static ArrayList<ArrayList<Toy>> toys = new ArrayList<>();
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] part = new int[n+1];

        for(int i =0; i<=n; i++){
            toys.add(new ArrayList<>());
        }
        int[] basic = new int[n+1];
        for(int i =0; i<m; i++){
            String[] inputs = br.readLine().split(" ");
            int big = Integer.parseInt(inputs[0]);
            int small = Integer.parseInt(inputs[1]);
            int needs = Integer.parseInt(inputs[2]);
            part[small] += 1;
            basic[big] = -1;
            toys.get(big).add(new Toy(small, needs));
        }
        answer = new int[n+1];


        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(n);
        answer[n] = 1;

        while(!queue.isEmpty()){
            Integer now = queue.poll();
            for(Toy toy: toys.get(now)){
                answer[toy.number] += answer[now] * toy.needs;
                part[toy.number] -=1;

                if(part[toy.number] ==0){
                    queue.offer(toy.number);
                }
            }
        }

        for(int i =1; i<n+1; i++){
            if(basic[i] == 0){
                bw.write(i +" " + answer[i] +"\n");
            }
        }



        bw.flush();
        bw.close();
        br.close();
    }

}
