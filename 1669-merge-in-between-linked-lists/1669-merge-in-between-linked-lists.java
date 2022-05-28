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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = list1;
        ListNode next = list1;
        ListNode temp = list2;
        int st = a;
        int ed = b;
        while(temp.next != null)temp = temp.next;
        
        
        while(prev != null && a-->1 && b-->1)prev = prev.next;
        next = prev;
        while(next != null &&  b-- > 1)next = next.next;
        if(next == null)next = prev; 
        ListNode ans = list1;
        
        
        temp.next = next.next.next;
        next.next = temp;
        
        if( st == 0)ans = list2;
        else prev.next = list2;
        
        return ans;
        
        
    }
}