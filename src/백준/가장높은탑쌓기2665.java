import java.util.*;
import java.io.*;

public class Main  {
    static class Top{
      int width;
      int height;
      int weight;

      Top(int width, int height, int weight){
          this.width = width;
          this.height = height;
          this.weight = weight;
      }
      public int getWidth(){
          return -this.width;
      }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Top[] tops = new Top[n];
    Map<Integer, Integer> store = new HashMap<>();
    for(int i =0; i<n; i++){
        String[] inputs = br.readLine().split(" ");
        tops[i] =  new Top(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
        store.put(tops[i].width, i+1);
    }
    Arrays.sort(tops, Comparator.comparing(Top::getWidth));
    int[] dy = new int[n];

    dy[0] = tops[0].height;
    ArrayList<ArrayList<Integer>> dyTrack = new ArrayList<>();

    for(int i =0; i<n; i++){
        dyTrack.add(new ArrayList<>());
        dyTrack.get(i).add(tops[i].width);
    }
    int answer = -1;
    int last = -1;
    for(int i =0; i<n; i++){
      dy[i] = tops[i].height;
      for(int j=0; j<i; j++){
          if((tops[i].width < tops[j].width) && (tops[i].weight < tops[j].weight)){
              if(dy[i] < dy[j] + tops[i].height){
                  dy[i] = dy[j] + tops[i].height;
                  dyTrack.set(i, new ArrayList<>(dyTrack.get(j)));
                  dyTrack.get(i).add(tops[i].width);
              }
          }
      }
        if(dy[i] > answer){
            answer = dy[i];
            last = i;
        }
        answer = Math.max(dy[i], answer);
    }
    ArrayList<Integer> track =  dyTrack.get(last);
    bw.write(track.size() + "\n");
    for(int i =track.size()-1; i>=0; i--){
        bw.write(store.get(track.get(i)) +"\n");
    }

    bw.flush();
    bw.close();
    br.close();

  }
}