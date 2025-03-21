import java.util.*;
class Solution {
    int n;
    int answer = 1;
    int[] CARDS;

    public int solution(int coin, int[] cards) {
        HashSet<Integer> myCards = new HashSet<>();
        HashSet<Integer> newCards = new HashSet<>();
        int i = (cards.length)/3;
        for(int j =0; j<(cards.length)/3; j++){
            myCards.add(cards[j]);
        }
        int target = cards.length+1;
        while(i < cards.length ){

            newCards.add(cards[i]);
            newCards.add(cards[i+1]);

            i = i+2;

            boolean flag = false;
            for(Integer c: myCards){
                if(myCards.contains(target-c)){
                    myCards.remove(c);
                    myCards.remove(target-c);
                    flag = true;
                    break;
                }
            }

            if(!flag && coin >=1){
                for(Integer c: myCards){
                    if(newCards.contains(target-c)){
                        myCards.remove(c);
                        newCards.remove(target-c);
                        flag = true;
                        coin--;
                        break;
                    }
                }
            }

            if(!flag && coin >=2){
                for(Integer c: newCards){
                    if(newCards.contains(target-c)){
                        newCards.remove(c);
                        newCards.remove(target-c);
                        flag = true;
                        coin -= 2;
                        break;
                    }
                }
            }
            if(!flag){
                break;
            }else{
                answer++;
            }
        }


        return answer;
    }
}