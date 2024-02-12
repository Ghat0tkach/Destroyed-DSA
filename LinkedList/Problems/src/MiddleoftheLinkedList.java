public class MiddleoftheLinkedList {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     //not single traversal , its my approach brute force

        public ListNode middleNode(ListNode head) {
            int sizeOfLinkedList=getSize(head);
            ListNode temp=head;
            int middleElement=0;
            if(sizeOfLinkedList%2==0){
                middleElement=(sizeOfLinkedList/2) +1;
            }
            else{
                middleElement=(sizeOfLinkedList+1)/2;
            }
            for(int i=0;i<middleElement-1;i++){
                temp=temp.next;
            }
            return temp;
        }
        public int getSize(ListNode A){
            ListNode temp=A;
            int count=0;
            while(temp!=null){
                count++;
                temp=temp.next;
            }
            return  count;
        }

    //Optimised approach
    public ListNode RightmiddleNodeInSingleTraversal(ListNode head) {
          ListNode slow=head;
          ListNode fast=head;
          while(fast!=null && fast.next!=null){
              slow=slow.next;
              fast=fast.next.next;
          }
          return slow;
    }
    public ListNode LeftmiddleNodeInSingleTraversal(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
