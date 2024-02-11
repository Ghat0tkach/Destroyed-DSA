public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;


         Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Node temp1 = head;

            // Step 1: Deep copy and insert new nodes
            while (temp1 != null) {
                Node copyNode = new Node(temp1.val);
                copyNode.next = temp1.next;
                temp1.next = copyNode;
                temp1 = copyNode.next;
            }

            // Step 2: Assign random pointers for the copied nodes
            temp1 = head;
            while (temp1 != null) {
                if (temp1.random != null) {
                    temp1.next.random = temp1.random.next;
                }
                temp1 = temp1.next.next;
            }

            // Step 3: Separate the original and copied lists
            Node originalHead = head;
            Node copiedHead = head.next;
            Node temp2 = copiedHead;

            while (originalHead != null) {
                originalHead.next = temp2.next;
                originalHead = originalHead.next;

                if (originalHead != null) {
                    temp2.next = originalHead.next;
                    temp2 = temp2.next;
                }
            }

            return copiedHead;
        }

    }
    public Node copyRandomList(Node head){
        // 7 13 11 10 1
        // n 7 1   11 7
        Node head2=new Node(0);
        Node DeepCopy=head2;
        Node temp1=head;
        // step 1: Deep copy code
        while(temp1!=null){
            Node t=new Node(temp1.val);
            DeepCopy.next=t;
            DeepCopy=t;
            temp1=temp1.next;
        }
        head2=head2.next;
        DeepCopy=head2;
        temp1=head;

        //alternate connections
        Node temp=new Node(-1);
        while(temp!=null){
            temp.next=temp1;
            temp1=temp.next;
            temp=temp.next;

            temp.next=DeepCopy;
            DeepCopy= DeepCopy.next;
            temp=temp.next;
        }
        DeepCopy=head2;
        temp1=head;
        //assigning random pointers
        while(temp1!=null && DeepCopy!=null){
            if(temp1.random==null) DeepCopy.random=null;
            else{
                DeepCopy.random=temp1.random.next;
                temp1=DeepCopy.next;
                DeepCopy=temp1.next;
            }

        }
        DeepCopy=head2;
        temp1=head;
        //seperating the list
        while(temp1!=null){
            temp1.next=DeepCopy.next;
            temp1=temp1.next;
            DeepCopy.next=temp1.next;
            if(DeepCopy.next==null) break;
            DeepCopy=DeepCopy.next;
        }

      //return
        return head2;
    }
}
//Step 1 create deep copy
// step 2 alternate connections
// step 3 assign random pointers
// step 4 seperate the lists