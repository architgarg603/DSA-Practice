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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l = head, r = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode temp = dummy;
        
        int cnt = left;
        while(cnt-->1)temp = temp.next;
        
        l = temp;
        r= temp.next;
        
        ListNode prev = null;
        ListNode next = null;
        temp = temp.next;
        
        for(int i=0;i<=right-left;i++){
           next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        
        l.next = prev;
        r.next = temp;
        
        return dummy.next;
    }
}