public class RemovingNthNodeFromEndOfLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static void display(Node head){
        Node temp2=head;
        while(temp2!=null){
            System.out.print(temp2.data+"-> ");
            temp2=temp2.next;
        }
    }
    public static void main(String[] args) {
        Node a= new Node(100);
        Node b= new Node(300);
        Node c= new Node(200);
        Node d= new Node(10);
        Node e= new Node(1200);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        display(a);
        Node temp=nthNode(a,6); //Unoptimised approach || Brute Force
        System.out.println();
        System.out.println(temp.data);
//        DeleteNode(temp,a);
        a=DeletenNthNodeinSingleTraversal(a,5);
        display(a);




    }
    public static Node nthNode(Node head, int n){
        int size=0;
        Node temp=head;
        while(temp!=null){
            size++;
            temp =temp.next;

        }
        int nthNodeFromStarting=size -n +1;
        //nth Node From Start
        temp=head;
        for (int i = 1; i <= nthNodeFromStarting-1; i++) {
            temp=temp.next;
        }
        return temp;

    }
    public static Node DeletenNthNodeinSingleTraversal(Node head, int n){
        Node slow=head;
        Node fast=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        if(fast==null){
            head=head.next;
            return head;
        }

        while(fast.next!=null){
                slow=slow.next;
                fast=fast.next;
        }


        slow.next=slow.next.next;
        return head;

    }
    public  static void DeleteNode(Node i,Node head){
        Node temp=head;
        while(temp.next!=i){
            temp=temp.next;
        }
        temp.next=temp.next.next;


    }


}
