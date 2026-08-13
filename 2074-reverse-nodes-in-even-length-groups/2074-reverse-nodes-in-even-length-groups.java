class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode frontNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = frontNode;
        }

        return prev;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {

        int group = 1;
        ListNode temp = head;
        ListNode previousGroup = null;

        while (temp != null) {

            // Start of current group
            ListNode groupStart = temp;
            ListNode groupEnd = null;

            int count = 0;

            // Find actual size of current group
            while (temp != null && count < group) {
                groupEnd = temp;
                temp = temp.next;
                count++;
            }

            // If group size is even
            if (count % 2 == 0) {

                // Save next group
                ListNode nextGroup = temp;

                // Disconnect current group
                groupEnd.next = null;

                // Reverse current group
                ListNode reversedHead = reverseList(groupStart);

                // Connect previous group to reversed group
                if (previousGroup != null) {
                    previousGroup.next = reversedHead;
                } else {
                    head = reversedHead;
                }

                // groupStart becomes the last node after reversal
                groupStart.next = nextGroup;

                // Update previousGroup
                previousGroup = groupStart;

            } else {

                // No reversal
                if (previousGroup != null) {
                    previousGroup.next = groupStart;
                }

                previousGroup = groupEnd;
            }

            group++;
        }

        return head;
    }
}