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

    public ListNode findLastNode(ListNode head , int n){
        int count = 1;

        while(head != null){
            if(count == n){
                return head;
            }
            count++;
            head = head.next;
        }
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        //Find length and lastNode;
        
        int length = 1;
        ListNode temp = head;

        if(head == null || head.next == null){
            return head;
        }

        while(temp.next != null){
            temp = temp.next;
            length++;
        }

        k = k % length;

        if(k == 0){
            return head;
        }

        temp.next = head;

        ListNode newTail = findLastNode(head , length - k);

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}