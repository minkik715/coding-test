
//0번째 자리부터 자리를 하나씩 선택해서 자리에 알맞게 넣음
public class Main{
    public static void main(String[] args) {
        int[] arr = {200, 40, 5, 30, 9, 10, 20};

        for(int i =0; i<arr.length-1; i++){
            int idx = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[idx]){
                    idx = j;
                }
            }
            if(idx != i){
                int t = arr[i];
                arr[i] = arr[idx];
                arr[idx] = t;
            }
        }

        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}

