package 종만북;

public class 이동평균 {
    public static void main(String[] args) {
        int[] t = new int[]{66, 70, 78, 80, 73, 67, 71};
        solution(t, 2);
        System.out.println("@@");
        solution2(t, 2);

    }

    private static void solution(int[] graph, int avgPer){
        int answer[] = new int[graph.length];
        for(int target = avgPer-1; target<graph.length; target++){
            int sum = 0;

            for(int pt= 0; pt<avgPer; pt++ ){
                sum += graph[target-pt];
            }
            answer[target] = sum/avgPer;
        }
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void solution2(int[] graph, int avgPer){
        int[] answer = new int[graph.length];
        int sum =0;
        for(int i =0; i<avgPer; i++){
            sum += graph[i];
        }
        answer[avgPer-1] = sum/avgPer;
        for(int i = avgPer; i< graph.length; i++){
            sum = sum + graph[i] - graph[i-avgPer];
            answer[i] = sum/avgPer;
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
