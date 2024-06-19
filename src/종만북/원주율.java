/*
package 종만북;

public class 원주율 {

    String n = "";

    int classify(int a, int b) {
        String m = n.substring(a, b - a + 1);
        char temp = m.charAt(0);
        boolean first = true;
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) != temp) {
                first = false;
            }
        }
        if (first) {
            return 1;
        }

        boolean second = true;
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i + 1) - m.charAt(i) != m.charAt(1) - m.charAt(0)) {
                second = false;
            }
        }
        if (second && Math.abs(m.charAt(1) - m.charAt(0)) == 1) {
            return 2;
        }

        boolean third = true;

        for (int i = 0; i < m.length(); i++) {
            if(m.charAt(i) != m.charAt(i%2)){
                third = false;
            }
        }
        if(third) return 4;
        if(second) return 5;
        return 10;
    }

    int memorize(int begin){
        if(begin == n.length()){
            return 0;
        }

    }
}
*/
