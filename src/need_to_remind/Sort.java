import java.util.*;

public class Main {
    public static class XY implements Comparable{
        int x;
        int y;
        XY(int x, int y ){
            this.x =x ;
            this.y = y;
        }

        @Override
        public int compareTo(Object o){
            XY x = (XY) o;
            return this.x - x.x;
        }

    }

    public static void main(String[] args) {
        XY[] xys = new XY[3];
        xys[0] = new XY(5, 4);
        xys[1] = new XY(20, 4);
        xys[2] = new XY(3, 4);
        Arrays.sort(xys);

        for(int i =0; i<5; i++){
            if(xys[i] != null){
                System.out.println(xys[i].x);
            }
        }

        ArrayList<XY> l = new ArrayList<XY>();
        l.add(new XY(2, 4));
        l.add(new XY(90, 4));
        l.add(new XY(4, 4));
        l.add(new XY(2, 4));
        l.add(new XY(2000, 4));
        l.sort();
        for(XY x : l){
            System.out.println(x.x);
        }
    }
}