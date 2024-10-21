package 종만북;


class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int stop = -1;
        String answer = "";
        int upper = 0;
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        int l1Size = 0;
        int l2Size = 0;
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;

        while (tempL1 != null) {
            tempL1 = tempL1.next;
            l1Size++;
        }
        while (tempL2 != null) {
            tempL2 = tempL2.next;
            l2Size++;
        }

        if (l1Size > l2Size) {
            ListNode answerNode = null;
            ListNode tempNode = null;
            ListNode nextNode = null;
            for (int i = 0; i < l1Size- l2Size; i++) {
                if (answerNode == null) {
                    answerNode = new ListNode(0);
                    nextNode = answerNode;
                } else {
                    tempNode = new ListNode(0);
                    nextNode.next = tempNode;
                    nextNode = tempNode;
                }
            }
            nextNode.next = l2;
            l2Node = answerNode;

        } else if (l2Size > l1Size) {
            ListNode answerNode = null;
            ListNode tempNode = null;
            ListNode nextNode = null;
            for (int i = 0; i < l1Size- l2Size; i++) {
                if (answerNode == null) {
                    answerNode = new ListNode(0);
                    nextNode = answerNode;
                } else {
                    tempNode = new ListNode(0);
                    nextNode.next = tempNode;
                    nextNode = tempNode;
                }
            }
            nextNode.next = l1;
            l1Node = answerNode;
        }


        System.out.println(l1Size);


        while (true) {
            if (l1Node == null) {
                stop = 1;
                break;
            }
            if (l2Node == null) {
                stop = 2;
                break;
            }
            int inputTemp = l1Node.val + l2Node.val + upper;
            int inputValue = inputTemp % 10;
            upper = inputTemp / 10;
            answer += String.valueOf(inputValue);
            l1Node = l1Node.next;
            l2Node = l2Node.next;
        }

        if (stop == 1) {
            while (l2Node != null) {
                answer += String.valueOf(l2Node.val);
                l2Node = l2Node.next;
            }
        }
        if (stop == 2) {
            while (l1Node != null) {
                answer += String.valueOf(l1Node.val);
                l1Node = l1Node.next;
            }
        }
        ListNode answerNode = null;
        ListNode tempNode = null;
        ListNode nextNode = null;
        for (int i = 0; i < answer.length(); i++) {
            if (answerNode == null) {
                answerNode = new ListNode(Integer.parseInt(String.valueOf(answer.charAt(i))));
                nextNode = answerNode;
            } else {
                tempNode = new ListNode(Integer.parseInt(String.valueOf(answer.charAt(i))));
                nextNode.next = tempNode;
                nextNode = tempNode;
            }
        }
        return answerNode;
    }
}