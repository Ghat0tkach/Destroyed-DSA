//https://leetcode.com/problems/reorder-list/description/
public class ReorderList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public static ListNode IterativeReverseLinkedList(ListNode head){
        ListNode currentNode=head;
        ListNode prevNode=null;
        ListNode nextNode=null;
        while(currentNode!=null){
            nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
        return prevNode;

    }
      public void reorderList(ListNode head){
          if(head==null || head.next==null){
              return;
          }
         //Find middle element
          ListNode mid=LeftmiddleNodeInSingleTraversal(head);
          //reverse the list from middle element to last
          ListNode headStart=IterativeReverseLinkedList(mid);
          ListNode headFirst=head;

          //rearrange
          while(headFirst!=null && headStart!=null){
              ListNode temp=headFirst.next;
              headFirst.next=headStart;
              headFirst=temp;

              temp=headStart.next;
              headStart.next=headFirst;
              headStart=temp;

          }
          //setting next tail on null
          if(headFirst!=null){
              headFirst.next=null;
          }
      }

}
