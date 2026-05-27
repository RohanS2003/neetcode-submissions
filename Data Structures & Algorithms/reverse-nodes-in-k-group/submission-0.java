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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=new ListNode(0);
        temp.next=head;

        ListNode groupPrev=temp;

        while(true){
            ListNode kNode=getKth(groupPrev, k);

            if(kNode==null){
                break;
            }

            ListNode groupStart=groupPrev.next;
            ListNode nextGroupStart=kNode.next;

            ListNode newGroupHead=reverse(groupStart, nextGroupStart);

            // connect previous group to reversed group
            groupPrev.next=newGroupHead;

            // groupStart became the tail tail of the reversed group after reversal
            groupPrev=groupStart;
        }
        return temp.next;
    }

    private ListNode reverse(ListNode start, ListNode end){
        ListNode prev=end;
        ListNode curr=start;

        while(curr!=end){
            ListNode next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
