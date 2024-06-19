package 종만북;

import java.io.*;
import java.util.Scanner;

public class 팬미팅 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc =new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());

        for(int i =0; i<c; i++){
            String members = sc.nextLine();
            String fans = sc.nextLine();
            System.out.println((letsHug(members, fans)));
        }
        sc.close();
    }

    public static int letsHug(String members, String fans) {
        String binMember = members.replace("F", "0").replace("M", "1");
        String binFan = fans.replace("F", "0").replace("M", "1");
        int memSize = binMember.length();
        int fanSize = binFan.length();
        int answer = 0;
        long memBinValue = Long.parseUnsignedLong(binMember, 2);

        for (int i = memSize - 1; i < fanSize; i++) {
            String currentFans = binFan.substring(i - memSize + 1, i+1);
            if (((Long.parseUnsignedLong(currentFans, 2) & memBinValue)) == 0) {
                answer++;
            }
        }
        return answer;

    }
}
