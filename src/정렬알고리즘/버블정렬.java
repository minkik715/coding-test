
// 거품들이 옆으로 처지는 것처럼 결국에 제일 큰게 뒤로 계속 밀린다.
public class Main{
    public static void main(String[] args) {
        int[] arr = {200, 40, 5, 30, 9, 10, 20};

        for(int i =arr.length-2; i>=0; i--){
            for(int j=0; j <=i; j++){
                if(arr[j] > arr[j+1]){
                    int t= arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }
            }
        }

        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}

