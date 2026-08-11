class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            // Find the kth node from groupPrev
            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Fewer than k nodes remain
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // Reverse the k nodes
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the previous part to the reversed group
            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;

            // Move to the next group
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }
}
