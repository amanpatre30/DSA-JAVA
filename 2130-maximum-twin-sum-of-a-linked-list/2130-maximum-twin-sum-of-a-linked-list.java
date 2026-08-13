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

    public ListNode middelNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode frontNode = temp.next;
            temp.next = prev;
            prev = temp ;
            temp = frontNode;
        }

        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode secondHalf = middelNode(head);
        ListNode reverseSecondHalf = reverse(secondHalf);

        ListNode first = head;
        ListNode second = reverseSecondHalf;
        
        int maxSum = 0;
        while(second != null){
            int sum = first.val + second.val;
            maxSum = Math.max(maxSum , sum);

            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
}