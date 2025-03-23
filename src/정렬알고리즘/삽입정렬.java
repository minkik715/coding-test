

//큰값을 오른쪽으로 밀고 작은 값을 앞에 삽입한다.
public class Main{
    public static void main(String[] args) {
        int[] arr = {200, 40, 5, 30, 9, 10, 20};

        for(int i =1; i<arr.length; i++){
            int t= arr[i];
            int idx = i;
            for(int j = i-1; j>=0; j--){
                if(arr[j] > t){
                    arr[j+1] = arr[j];
                    idx = j;
                }else{
                    arr[j] = t;
                    break;
                }
            }
        }

        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}

