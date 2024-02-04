import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class 좌표정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Location> locations = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String x = s[0];
            String y = s[1];
            locations.add(new Location(Integer.parseInt(x), Integer.parseInt(y)));
        }

        solution(locations);

    }

    private static String solution(List<Location> locations) {
        Comparator<Location> locationCompare = new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        };

        locations.sort(locationCompare);

        for (Location location : locations) {
            System.out.println(location.toString());
        }

        return null;
    }


    public static class Location {

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}
