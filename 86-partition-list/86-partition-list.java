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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        ListNode temp = new ListNode();
        ListNode idx = dummy;
        ListNode idx1 = temp;
        dummy.next = head;
        while( idx != null && idx.next !=null){
            if(idx.next.val < x){
                ListNode dNode = idx.next;
                idx.next = idx.next.next;
                idx1.next = dNode;
                idx1=idx1.next;
            }else{
                idx = idx.next;
            }
        }
        idx1.next = dummy.next;
        return temp.next;
    }
    
   
}