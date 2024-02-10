public class ReverseALinkedList {
    public static class ListNode{
        int val;
       ListNode next;
        ListNode( int val){
            this.val=val;
        }
    }
    public static  void display(ListNode head){
        if(head==null) return; //base case
        System.out.print(head.val + " ");//call
        display(head.next);//work

    }
    public static  void reversedisplay(ListNode head){
        if(head==null) return; //base case
        display(head.next);//work
        System.out.print(head.val + " ");//call

    }
    public  static ListNode RecursiveReverseLinkedList(ListNode head){
        if(head.next==null) return head;
        ListNode newHead= RecursiveReverseLinkedList(head.next);
        head.next.next=head; //inter changing connections
        head.next=null;
        return  newHead;
        //O(N) space complexity and time complexity
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




    public static void main(String[] args) {
        ListNode a=new ListNode(10);
        ListNode b=new ListNode(120);
        ListNode c=new ListNode(190);
        ListNode d=new ListNode(140);
        ListNode e=new ListNode(150);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
//        display(a);
//        System.out.println();
//        reversedisplay(a);
     //   ListNode reverse=RecursiveReverseLinkedList(a);
        ListNode reverse=IterativeReverseLinkedList(a);
        display(reverse);

    }

}
