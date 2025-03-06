// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        int[] distFromX = new int[n+1];
        int[] distToX = new int[n+1];
        Arrays.fill(distFromX, Integer.MAX_VALUE-101);
        Arrays.fill(distToX, Integer.MAX_VALUE-101);
        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        ArrayList<ArrayList<Edge>> reverse = new ArrayList<>();

        for(int i =0; i<=n; i++){
            edges.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }




        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            edges.get(Integer.parseInt(input[0])).add(new Edge(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
            reverse.get(Integer.parseInt(input[1])).add(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[2])));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w-o2.w);



            distFromX[x] = 0;

            pq.offer(new Edge(x, 0));

            while(!pq.isEmpty()){
                Edge e = pq.poll();
                int here = e.to;
                int w = e.w;


                if(w > distFromX[here]) continue;

                for(Edge ne: edges.get(here)){
                    int nw = w + ne.w;
                    int to = ne.to;
                    if(distFromX[to] > nw){
                        distFromX[to] = nw;
                        pq.offer(new Edge(to, nw));
                    }
                }
            }

            distToX[x] = 0;

            pq.offer(new Edge(x, 0));

            while(!pq.isEmpty()){
                Edge e = pq.poll();
                int here = e.to;
                int w = e.w;


                if(w > distToX[here]) continue;

                for(Edge ne: reverse.get(here)){
                    int nw = w + ne.w;
                    int to = ne.to;
                    if(distToX[to] > nw){
                        distToX[to] = nw;
                        pq.offer(new Edge(to, nw));
                    }
                }
            }

        int answer= -1;

        for(int i =1; i<=n; i++){
            answer = Math.max(answer, distFromX[i] + distToX[i]);
        }

        bw.write(answer+ "");

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