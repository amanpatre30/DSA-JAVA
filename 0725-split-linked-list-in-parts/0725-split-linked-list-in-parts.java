/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        ListNode arr[] = new ListNode[k];
        int sizeOfsubList = count / k;
        int extraNode = count % k;

        ListNode temp1 = head;
        
        for(int i = 0 ; i < k ; i++){
            
            int currentSize = sizeOfsubList;
            
            if(extraNode > 0){
                currentSize++;
                extraNode--;
            }

            arr[i] = temp1;
            ListNode lastNode = null;

            for(int j = 0 ; j < currentSize ; j++){

                if(temp1 != null){
                    lastNode = temp1;
                    temp1 = temp1.next;
                }

            }

            if(lastNode != null){
                lastNode.next = null;
            }
        }
        return arr;
    }
}