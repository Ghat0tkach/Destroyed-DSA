//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOfTwoLinkedLists {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    public static void main(String[] args) {


    }
    public Node getInterSectionNode(Node A, Node B){
            Node tempA=A;
            Node tempB=B;
            int sizeofA=getSize(A);
            int sizeofB=getSize(B);
            if(sizeofA>sizeofB){
                int steps=sizeofA-sizeofB;
                for (int i = 0; i <steps ; i++) {
                    tempA=tempA.next;
                }
            }
            else {
                int steps=sizeofB-sizeofA;
                for (int i = 0; i <steps ; i++) {
                    tempB=tempB.next;
                }
            }
            while(tempA!=tempB){
                tempA=tempA.next;
                tempB=tempB.next;
            }
            return  tempA;
    }
    public int getSize(Node A){
            Node temp=A;
            int count=0;
            while(temp!=null){
                count++;
                temp=temp.next;
            }
            return  count;
    }
}


}
