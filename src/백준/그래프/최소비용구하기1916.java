import java.util.*;
import java.io.*;

class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        for(int i =0; i<=n; i++){
            edges.add(new ArrayList<>());
        }

        for(int i =0; i<m; i++){
            String[] input = br.readLine().split(" ");
            edges.get(Integer.parseInt(input[0])).add(new Edge(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        int[] dist = new int[n +1 ];

        Arrays.fill(dist, Integer.MAX_VALUE - 100001);

        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            int here = e.to;
            int w = e.w;

            if(w > dist[here]) continue;

            for(Edge ne: edges.get(here)){
                int nw = ne.w + w;
                int to = ne.to;
                if(dist[to] > nw){
                    dist[to] = nw;
                    pq.offer(new Edge(to, nw));
                }
            }
        }

        bw.write(dist[target] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge{
        int to;
        int w;

        Edge(int to, int w){
            this.to = to;
            this.w =w;
        }

    }
}