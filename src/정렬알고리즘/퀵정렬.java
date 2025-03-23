// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int[] arr = {200, 40, 5, 30, 9, 10, 20};


        quickSort(0, arr.length-1, arr);
        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static void quickSort(int l, int r, int[] arr){
        if(l < r){
            int mid = (l+r)/2;
            int p = partition(l, r, arr);
            quickSort(l, p-1, arr);
            quickSort(p+1, r, arr);
        }
    }

    static int partition(int l, int r, int[] arr){
        int mid =(l+r)/2;
        int pivot = arr[mid];

        swap(mid, r, arr);
        int i = l;
        for(int j =l; j<r; j++){
            if(arr[j] <=pivot){
                swap(i, j, arr);
                i++;
            }
        }
        swap(i, r, arr);
        return i;
    }

    static void swap(int a, int b, int[] arr){
        int t= arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}