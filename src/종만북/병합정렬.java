package 종만북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 병합정렬 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        mergeSort(0, arr.length-1);
        for (int arg : arr) {
            System.out.print(arg);
        }
    }

    private static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, end);
    }

    private static void merge(int start, int end) {

        int mid = (start + end) / 2;
        int leftStart = start;
        int rightStart = mid + 1;
        int idx = start;
        int temp[] = new int[end + 1];

        while (leftStart <= mid && rightStart <= end) {
            if (arr[leftStart] >= arr[rightStart]) {
                temp[idx++] = arr[rightStart++];
            } else {
                temp[idx++] = arr[leftStart++];
            }
        }

        while (leftStart <= mid) {
            temp[idx++] = arr[leftStart++];
        }

        while (rightStart <=end){
            temp[idx++] = arr[rightStart++];
        }

        for(int i =start; i<=end; i++){
            arr[i] = temp[i];
        }

    }
}
