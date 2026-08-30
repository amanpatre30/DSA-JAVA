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
    public ListNode reverseList(ListNode head){
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

    public ListNode findKthNode(ListNode head , int k){
        k -= 1;
        while(head != null && k > 0){
            k--;
            head = head.next;
        }
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp!= null){
            ListNode kthNode = findKthNode(temp , k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            ListNode frontNode = kthNode.next;
            kthNode.next = null;
            reverseList(kthNode);
            if(temp == head){
                head = kthNode;
            }else{
                prevNode = temp;
                prev
            }
        }
    }
}