class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while( temp != null){
           ListNode kthNode = getKthNode(temp, k);
            if( kthNode == null){
                if(prevLast != null) prevLast.next = temp;
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);
            
            if( temp == head){
                head = kthNode;
            }
            else{
                prevLast.next = kthNode;
            }

           
            prevLast = temp;
            temp = nextNode;

        }


        return head;
    }
    public ListNode getKthNode(ListNode temp, int k){
        k = k - 1;
        while( temp != null && k > 0){
            k --;
            temp = temp.next;
        }

        return temp;
    }
    public void reverseLinkedList(ListNode temp){
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
    }

}