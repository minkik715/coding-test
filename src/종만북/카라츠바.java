package 종만북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 카라츠바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] reverseA = reverse(a);
        int[] reverseB = reverse(b);
        for (int i : reverse(multiplyIntList(reverseA, reverseB))) {
            System.out.print(i);
        }

    }

    private static int[] multiplyIntList(int[] a, int[] b) {
        if (a.length < b.length) {
            return multiplyIntList(b, a);
        }
        int[] c = new int[a.length * b.length + 1];

        for (int i = 0; i < b.length; i++) {
            int bTarget = b[i];
            for (int j = 0; j < a.length; j++) {
                int aTarget = a[j];
                c[i + j] = aTarget * bTarget;
            }
        }
        return normalize(c);
    }

    private static int[] normalize(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0) {
                int burrow = (Math.abs(arr[i]) + 9) / 10;
                arr[i + 1] -= burrow;
                arr[i] += burrow * 10;
            } else {
                arr[i + 1] += arr[i] / 10;
                arr[i] = arr[i] % 10;
            }
        }
        return arr;
    }

    private static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];  // Create a new array for the reversed elements
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    private int[] karatsuba(int[] a, int[] b) {

        int an = a.length;
        int bn = b.length;
        int mid = an / 2;

        if (an == 0 || bn == 0) {
            return new int[];
        }

        int[] a0 = new int[mid + 1];
        int[] a1 = new int[mid + 1];
        int[] b0 = new int[mid + 1];
        int[] b1 = new int[mid + 1];

        int[] z2 = karatsuba(a1, b1);
        int[] z0 = karatsuba(a0, b0);

        addTo(a0, a1, 0);
        addTo(b0, b1, 0);

        int[] z1 = karatsuba(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);

        int[] result = new int[an * b.length + 1];
        addTo(result, z0, 0);
        addTo(result, z1, mid);
        addTo(result, z2, mid * 2);
        return result
    }

    private int[] addTo(int[] a, int[] b, int k) {
        a = expandSize(a, b.length+k);
        for (int i = 0; i < b.length; i++) {
            a[i + k] = a[i + k] + b[i];
        }
        return normalize(a);
    }

    private int[] subFrom(int[] a, int[] b) {
        a = expandSize(a, b.length);
        for (int i = 0; i < b.length; i++) {
            a[i] = a[i] - b[i];
        }
        return normalize(a);
    }

    private int[] expandSize(int[] arr, int size) {
        if (arr.length < size) {
            int[] t = new int[size + 1];
            for (int i = 0; i < arr.length; i++) {
                t[i] = arr[i];

            }
            return t;
        }
        return arr;
    }
}
