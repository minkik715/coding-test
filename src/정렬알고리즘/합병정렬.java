class Main {
    public static void main(String[] args) {
        int[] arr = {200, 40, 5, 30, 9, 10, 20};


        divide(0, arr.length-1, arr);
        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static void divide(int l, int r, int[] arr){
        if(l < r){
            int mid = (l+r)/2;

            divide(l, mid, arr);
            divide(mid+1, r, arr);

            merge(l, mid, r, arr);
        }
    }

    static void merge(int l, int mid, int r, int[] arr){
        int n1 = mid -l +1;
        int n2 = r-mid;
        int[] lArr = new int[n1];
        int[] rArr = new int[n2];
        for(int j=0; j<n1; j++){
            lArr[j] = arr[l+j];
        }
        for(int j=0; j<n2; j++){
            rArr[j] = arr[mid+1+j];
        }
        int j =0;
        int i =0;
        int k =l;

        while(i < n1 && j < n2 ){
            if(lArr[i] < rArr[j]){
                arr[k] = lArr[i];
                i++;
            }else{
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = lArr[i];
            k++;
            i++;
        }
        while(j < n2){
            arr[k] = rArr[j];
            k++;
            j++;
        }
    }
}