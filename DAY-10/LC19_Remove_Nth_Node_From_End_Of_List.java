class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Handle single node list
        if (head.next == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        int i = 1;
        while (i <= n) {
            fast = ptr.next; 
            i++;
        }
        
        // If fast becomes null, we need to remove the head
        if (fast == null) return head.next;
        
        // Move both until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        } 
        
        // Skip the nth node from the end
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        
        return head;
    }
}