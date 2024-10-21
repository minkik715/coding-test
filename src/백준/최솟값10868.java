package 백준;




import java.io.*;



public class 최솟값10868 {

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static int[] tree;

    static int[] numbers;

    static Pair[] sections;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int sectionInputs = Integer.parseInt(input[1]);
        numbers = new int[n + 1];
        sections = new Pair[sectionInputs];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<sectionInputs; i++){
            String[] section = br.readLine().split(" ");
            sections[i] = new Pair(Integer.parseInt(section[0]), Integer.parseInt(section[1]));
        }

        tree = new int[n*4];

        init(1,n, 1);
        for (Pair section : sections) {
            bw.write(getMin(1, n,section.first, section.second, 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = numbers[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, (node * 2) + 1));
    }

    public static int getMin(int start, int end, int from, int to, int node){
        if(from >end || to < start) return Integer.MAX_VALUE;

        if(from <= start &&  end <= to ) return tree[node];

        int mid = (start+end)/2;
        return Math.min(
                getMin(start, mid, from, to, node*2),
                getMin(mid+1, end, from, to, node*2+1)
        );


    }

}
