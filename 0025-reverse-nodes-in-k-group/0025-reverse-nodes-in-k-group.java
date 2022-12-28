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
    
    public static ListNode MoveToKthNode(ListNode root, int times){
        while(root != null && times > 0){
            root = root.next;
            times--;
        }
        return root;
    }        

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupLast = dummy;
        while(true){
            ListNode currGroupLast = MoveToKthNode(prevGroupLast, k);
            if(currGroupLast == null) break;
            ListNode nextGroupFirst = currGroupLast.next;
            ListNode curr = prevGroupLast.next;
            ListNode prev = nextGroupFirst;
            while(curr != nextGroupFirst){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode currGroupFirst = prevGroupLast.next;
            prevGroupLast.next = currGroupLast;
            prevGroupLast = currGroupFirst;
        }        
        return dummy.next;        
    }
}