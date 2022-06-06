/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        int x=0,y=0;
        
        while(t1 != null){
            t1 = t1.next;
            x++;
        }
        while(t2 != null){
            t2 = t2.next;
            y++;
        }
        
        return (x>y ? solve(x,y,headA, headB) : solve(y,x,headB,headA));
        
        
    }
    
    public ListNode solve(int x, int y, ListNode t1, ListNode t2){
        int t = x-y;
        while(t-->0)t1 = t1.next;
        
        while(t1 != t2 && t1 != null && t2 != null){
            t1 = t1.next;
            t2= t2.next;
        }
        
        
        return t1;
    }
}