import java.util.List;

public class OddEvenLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode( int val){
            this.val=val;
        }
    }
    public  static  void display(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
    }

    public static ListNode OddEvenLinkedList(ListNode head){
        ListNode even=new ListNode(0);
        ListNode odd=new ListNode(0);
        ListNode tempOdd=odd;
        ListNode tempEven=even;
        ListNode temp=head;
        while(temp!=null){
            tempOdd.next=temp;
            temp=temp.next;
            tempOdd=tempOdd.next;

            tempEven.next=temp;
            if(temp==null) break;
            temp=temp.next;
            tempEven=tempEven.next;



        }
        odd=odd.next;
        even=even.next;
        tempOdd.next=even;
        return odd;



    }

    public static void main(String[] args) {
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(1);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(5);
        ListNode e=new ListNode(6);
        ListNode f=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
//        display(a);
        ListNode oddEven=OddEvenLinkedList(a);
        display(oddEven);


    }

}
