class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null ||head.next == null|| k == 0) return head;

        ListNode temp = head;

        int len = 1;
        while( temp.next != null){
            len++;
            temp = temp.next;
        }

        k =  k % len;

        if( k == 0) return head;

        temp.next = head;
        
        ListNode tail = head;
        int val = len - k - 1;
        while( val > 0 && tail != null){
          val--;
          tail = tail.next;
          
        }
        head = tail.next;
        tail.next = null;

        return head;
        
    }
}