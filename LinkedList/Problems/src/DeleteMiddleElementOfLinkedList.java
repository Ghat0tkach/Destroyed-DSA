public class DeleteMiddleElementOfLinkedList {

    public static class Node{
    int value;
    Node next;

    public  Node(int value){
        this.value=value;
    }
}

public static void display(Node head){
        Node temp2=head;
        while(temp2!=null){
            System.out.print(temp2.value+"-> ");
            temp2=temp2.next;
        }
    }
    public static void main(String[] args) {
        Node a=new Node(100);
        Node b=new Node(110);
        Node c=new Node(200);
        Node d=new Node(10);
        Node e=new Node(130);
        Node f=new Node(30);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        display(a);
        System.out.println();
        DeleteMiddleLeftElementofLinkedList(a);
        display(a);


    }
    public static void DeleteMiddleElementofLinkedList(Node head){
        if(head.next==null){
            return;
        }
        Node slow=head;
        Node fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;
            fast=fast.next.next.next;
        }
        slow.next=slow.next.next;
    }
    //Only for even
    public static void DeleteMiddleLeftElementofLinkedList(Node head){
        if(head.next==null){
            return;
        }
        Node slow=head;
        Node fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null && fast.next.next.next.next!=null){
            slow=slow.next;
            fast=fast.next.next.next;
        }
        slow.next=slow.next.next;
    }

}
