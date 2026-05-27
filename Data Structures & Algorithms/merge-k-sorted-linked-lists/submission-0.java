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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(
            (a,b)->a.val-b.val
        );

        for(ListNode list:lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }

        ListNode temp=new ListNode(0);
        ListNode curr=temp;

        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();

            curr.next=node;
            curr=curr.next;

            if(node.next!=null){
                minHeap.offer(node.next);
            }
        }
        return temp.next;
    }
}
