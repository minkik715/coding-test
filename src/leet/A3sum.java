package leet;

import java.util.*;

class A3sum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,0};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> numStore = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            Integer value = numStore.get(key);
            if (value == null) {
                numStore.put(key, 1);
            } else {
                numStore.put(key, ++value);
            }
        }
        HashSet<String> checkNum = new HashSet<>();

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            int first = nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                int second = nums[j];
                int key = -(first + second);

                Integer value = numStore.get(key);
                if (value != null) {
                    String fString = String.valueOf(first);
                    String sString = String.valueOf(second);
                    String kString = String.valueOf(key);
                    int newValue = value;
                    if(key == first){
                        newValue--;
                    }
                    if(key == second){
                        newValue--;
                    }
                    boolean result = false;
                    if (key == first || key == second) {
                        if (newValue != 0) {
                            if(!checkNum.contains(fString + sString + kString)){
                                result = true;
                            }

                        }
                    } else {
                        if(!checkNum.contains(fString + sString + kString)){
                            result = true;
                        }
                    }

                    if(result) {
                        ArrayList<Integer> ints = new ArrayList<>();
                        ints.add(first);
                        ints.add(second);
                        ints.add(key);
                        answer.add(ints);
                        checkNum.add(fString + sString + kString);
                        checkNum.add(fString + kString + sString);
                        checkNum.add(sString + fString + kString);
                        checkNum.add(sString + kString + fString);
                        checkNum.add(kString + sString + fString);
                        checkNum.add(kString + fString + sString);
                    }
                }
            }
        }
        return answer;
    }
}