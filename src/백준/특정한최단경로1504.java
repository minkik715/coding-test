package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 특정한최단경로1504 {

    public static class Pair{
        int loc;
        int w;

        Pair(int loc, int w){
            this.loc = loc;
            this.w = w;
        }

        int getW(){
            return w;
        }
    }

   static int v;
   static ArrayList<ArrayList<Pair>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        adj = new ArrayList<>();
        for(int i =0; i<=v; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<e; i++){
            String[] vInput = br.readLine().split(" ");

            int src = Integer.parseInt(vInput[0]);
            int des = Integer.parseInt(vInput[1]);
            int w = Integer.parseInt(vInput[2]);
            adj.get(src).add(new Pair(des,w));
            adj.get(des).add(new Pair(src,w));
        }
        String[] c = br.readLine().split(" ");

        int c1 = Integer.parseInt(c[0]);
        int c2 = Integer.parseInt(c[1]);

        int[] src1 = dijkstra(1);
        int[] srcc1 = dijkstra(c1);
        int[] srcc2 = dijkstra(c2);

        int answer =
                Math.min(src1[c1] + srcc1[c2] + srcc2[v], src1[c2]+ srcc2[c1] + srcc1[v]);
        if(answer > ((Integer.MAX_VALUE-30)/3 -1 ) ) answer = -1;
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int[] dijkstra(int src){
        int[] dist = new int[v+1];

        Arrays.fill(dist,(Integer.MAX_VALUE-30) /3);
        dist[src] = 0;


        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getW));

        pq.offer(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int here = current.loc;
            int cost = current.w;
            if( cost> dist[here]) continue;
            dist[here] = cost;

            for(Pair p : adj.get(here)){
                int there = p.loc;
                int thereCost = p.w;

                if(dist[here] + thereCost < dist[there]){
                    pq.offer(new Pair(there, dist[here]+ thereCost));
                }
            }
        }
        return dist;

    }
}
