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
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode frontNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = frontNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
         ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second Half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        while(secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }
}