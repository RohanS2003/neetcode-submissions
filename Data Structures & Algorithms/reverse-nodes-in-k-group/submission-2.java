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

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        // Dummy node helps us handle changes at the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // groupPrev always points to the node before the current group
        ListNode groupPrev = dummy;

        while (true) {
            // Step 1: find the kth node from groupPrev
            // For example, if groupPrev is dummy and k = 3,
            // kth will be node 3 for the first group (1 -> 2 -> 3)
            ListNode kth = getKthNode(groupPrev, k);

            // If fewer than k nodes remain, stop
            if (kth == null) break;

            // Step 2: mark the node after the group
            // Example: for group 1 -> 2 -> 3, groupNext = 4
            ListNode groupNext = kth.next;

            // Step 3: reverse the current group
            // prev starts at groupNext so the reversed group connects to the rest
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            // Reverse until curr reaches groupNext
            while (curr != groupNext) {
                ListNode temp = curr.next; // save next node

                // reverse the pointer
                curr.next = prev;

                // move both pointers forward
                prev = curr;
                curr = temp;
            }

            // Step 4: reconnect the reversed group back to the list
            // groupPrev.next was old head of group
            // kth is new head after reversal
            ListNode temp = groupPrev.next; // old head becomes the tail of this group
            groupPrev.next = kth;           // connect previous part to new head
            groupPrev = temp;               // move groupPrev to the end of reversed group
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}