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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)return;

        ListNode middle=findMiddle(head);

        //split
        ListNode second=middle.next;
        middle.next=null;

        //rev
        second=reverseLL(second);

        //merge first half and second half
        ListNode first=head;

        while(second!=null){
            ListNode next1=first.next;
            ListNode next2=second.next;

            first.next=second;
            second.next=next1;

            first=next1;
            second=next2;
        }
    }

    private ListNode findMiddle(ListNode node){
        ListNode slow=node;
        ListNode fast=node;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
