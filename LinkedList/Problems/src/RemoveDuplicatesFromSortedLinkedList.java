public class RemoveDuplicatesFromSortedLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;

            }
            if(temp.next==null) break;
            if(temp.val!=temp.next.val) temp=temp.next;

        }
        return head;
    }
}
