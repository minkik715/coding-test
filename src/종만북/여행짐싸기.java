package 종만북;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class 여행짐싸기 {

    public static class Item {
        int occupy;
        int pri;

        String name;

        Item(int occupy, int pri, String name) {
            this.occupy = occupy;
            this.pri = pri;
            this.name = name;
        }
    }

    static Item[] items;
    static int maxOccupy;
    static int itemCnt;

    static int[][] cache;
    static ArrayList<Item> answer;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Comparator<Item> itemComparator = (o1, o2) -> {
            if (o1.occupy == o2.occupy) {
                return o1.pri - o2.pri;
            } else {
                return o1.occupy - o2.occupy;
            }
        };

        int t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++) {
            String[] s = br.readLine().split(" ");
            itemCnt = Integer.parseInt(s[0]);
            maxOccupy = Integer.parseInt(s[1]);
            items = new Item[itemCnt];
            answer = new ArrayList<>();
            cache = new int[maxOccupy + 1][itemCnt + 1];

            for (int i = 0; i < itemCnt; i++) {
                String[] s1 = br.readLine().split(" ");
                items[i] = new Item(Integer.parseInt(s1[1]), Integer.parseInt(s1[2]), s1[0]);
            }

            Arrays.sort(items, itemComparator);

            getAnswer(maxOccupy, 0);

            int priSum = 0;
            StringBuilder sb =new StringBuilder();
            for (Item item : answer) {
                priSum +=item.pri;
                sb.append(item.name + "\n");
            }

            bw.write(priSum + " " + answer.size() + "\n"  + sb);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getAnswer(int capacity, int itemIndex){
        if(itemIndex == itemCnt){
            return;
        }
        if(carry(capacity,itemIndex) == carry(capacity, itemIndex+1)){
            getAnswer(capacity, itemIndex+1);
        }else {
            Item item = items[itemIndex];
            answer.add(item);
            getAnswer(capacity-item.occupy, itemIndex+1);
        }
    }


    public static int carry(int capacity, int itemIndex) {
        if (itemIndex == itemCnt) return 0;

        int ret = cache[capacity][itemIndex];
        if(ret != 0){
            return ret;
        }
        ret = carry(capacity, itemIndex + 1);

        Item item = items[itemIndex];

        if (capacity >= item.occupy) {
            ret = Math.max(ret, carry(capacity - item.occupy, itemIndex + 1) + item.pri);
        }
        cache[capacity][itemIndex] = ret;

        return ret;
    }

}
