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

    public static ListNode reverse(ListNode node1, ListNode node2){
        if(node2 == null) return node1;
        ListNode root = reverse(node2, node2.next);
        node2.next = node1;
        return root;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h1 = reverse(null, slow);
        slow.next = null;
        ListNode h2 = head;
        while(h1.next != null && h2.next != null && (h1.val == h2.val)){
            h1 = h1.next;
            h2 = h2.next;
        }
        if(h1.val != h2.val) return false;
        return true;
    }
}