public class PalindromeLinkedList {
    public class  ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public static ListNode IterativeReverseLinkedList(ListNode head){
        ListNode currentNode=head;
        ListNode prevNode=null;
        ListNode nextNode;
        while(currentNode!=null){
            nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
        return prevNode;

    }
    public boolean isPalindrome(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=IterativeReverseLinkedList(slow.next);
        slow.next=temp;
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p2!=null){
            if(p1.val!=p2.val) return false;
            p1=p1.next;
            p2=p2.next;

        }
      return true;
    }
}
