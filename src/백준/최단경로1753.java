package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최단경로1753 {

    public static class Pair {
        int loc;
        int w;

        Pair(int loc, int w) {
            this.w = w;
            this.loc = loc;
        }

        int getW(){
            return this.w;
        }
    }

    static int v;
    static int e;
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    static int PROPER_MAX = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);

        int src = Integer.parseInt(br.readLine());

        for(int i =0; i<=v; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<e; i++){
            String[] inputs = br.readLine().split(" ");
            int here = Integer.parseInt(inputs[0]);
            int there = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);
            adj.get(here).add(new Pair(there, w));
        }

        int[] dist = dijkstra(src);

        for(int i =1; i<=v; i++){
            if(dist[i] >= PROPER_MAX){
                bw.write("INF\n");

            }else{
                bw.write(dist[i]+"\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();

    }

    public static int[] dijkstra(int src){
        int[] dist = new int[v+1];

        Arrays.fill(dist, PROPER_MAX);

        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getW));

        pq.offer(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int here = current.loc;
            int cost = current.w;

            if(cost > dist[here]) continue;

            dist[here] = cost;

            for(Pair ad: adj.get(here)){
                int there = ad.loc;
                int thereCost = ad.w + dist[here];

                if(dist[there] > thereCost){
                    pq.offer(new Pair(there, thereCost));
                }
            }
        }
        return dist;
    }
}
