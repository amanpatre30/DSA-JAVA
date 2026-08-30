class Solution {

    // Reverse the linked list starting from head
    public ListNode reverseList(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            // Store next node before changing the link
            ListNode frontNode = temp.next;

            // Reverse the link
            temp.next = prev;

            // Move prev forward
            prev = temp;

            // Move temp forward
            temp = frontNode;
        }

        // prev is the new head
        return prev;
    }

    // Find the kth node from head
    public ListNode findKthNode(ListNode head, int k) {

        // k = 1 means current node itself
        k -= 1;

        while (head != null && k > 0) {
            k--;
            head = head.next;
        }

        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;

        // Last node of previous reversed group
        ListNode prevNode = null;

        while (temp != null) {

            // Find kth node of current group
            ListNode kthNode = findKthNode(temp, k);

            // Less than k nodes remaining
            if (kthNode == null) {

                // Connect previous group with remaining nodes
                if (prevNode != null) {
                    prevNode.next = temp;
                }

                break;
            }

            // Save first node of next group
            ListNode frontNode = kthNode.next;

            // Cut current group from remaining list
            kthNode.next = null;

            // Reverse current group
            ListNode newHead = reverseList(temp);

            // If this is the first group
            if (temp == head) {
                head = newHead;
            } 
            else {
                // Connect previous group with current reversed group
                prevNode.next = newHead;
            }

            // After reversal, temp becomes the last node
            // of the current reversed group
            prevNode = temp;

            // Move to next group
            temp = frontNode;
        }

        return head;
    }
}