package study;

import java.util.ArrayList;
import java.util.Arrays;

public class Velpomahn {

    public static class Pair{
        int w;
        int loc;

        Pair(int loc, int w){
            this.w = w;
            this.loc = loc;
        }

    }


    public static void main(String[] args) {



    }

    static int V;

    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();


    public static void velpomahn(int src){
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for(int i =0; i<V-1; i++){
            for(int j=0; j<V; j++){
                int here = j;
                int cost = dist[here];
                for(Pair current: adj.get(j)){
                    int there = current.loc;
                    int costThere = cost + current.w;

                    if(dist[there] > costThere){
                        dist[there] = costThere;
                    }
                }
            }
        }

        boolean upper = false;
        for(int j=0; j<V; j++){
            int here = j;
            int cost = dist[here];
            for(Pair current: adj.get(j)){
                int there = current.loc;
                int costThere = cost + current.w;

                if(dist[there] > costThere){
                    dist[there] = costThere;
                    upper = true;
                }
            }
        }
    }


}
