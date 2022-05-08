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
    public ListNode reverseList(ListNode node) {
        ListNode dummy=null;
        while(node!=null){
            ListNode ahead=node.next;
            node.next=dummy;
            dummy=node;
            node=ahead;
        }
        return dummy;
}
}
        