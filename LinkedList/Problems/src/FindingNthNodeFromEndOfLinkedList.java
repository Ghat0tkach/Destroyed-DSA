//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class FindingNthNodeFromEndOfLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
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

        Node temp=nthNode(a,2); //Unoptimised approach || Brute Force
        System.out.println(temp.data);
        Node answer=nthNodeinSingleTraversal(a,2);
        System.out.println(answer.data);

    }
    public static Node nthNode(Node head,int n){
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
    public static Node nthNodeinSingleTraversal(Node head,int n){
        Node slow=head;
        Node fast=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return  slow;
    }




}
