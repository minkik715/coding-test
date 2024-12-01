package study;

import java.util.*;

public class Dijkstra {

    public static class Pair {
        int loc;
        int w;

        Pair(int loc, int w) {
            this.loc = loc;
            this.w = w;
        }

    }

    public static void main(String[] args) {
        dijkstra(0);
    }

    static int V = 10;

    static ArrayList<ArrayList<Pair>> adl = new ArrayList<>();

    public static int dijkstra(int src) {

        int[] dist = new int[V];
        dist[src] = 0;
        Queue<Pair> q = new ArrayDeque<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(o -> o.w));

        pq.add(new Pair(src, 0));


        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int weight = current.w;
            int here = current.loc;

            if(dist[here] < weight) continue;

            ArrayList<Pair> ad = adl.get(here);

            for(Pair p : ad){

                int nextDist = weight + p.w;

                if(dist[p.loc] > nextDist){
                    dist[p.loc] = nextDist;
                    pq.offer(new Pair(p.loc, nextDist));
                }
            }
        }
        return 0;
    }
}
