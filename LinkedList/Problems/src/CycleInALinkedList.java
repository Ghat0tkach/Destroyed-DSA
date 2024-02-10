//My solution

//public class Solution {
//    public boolean hasCycle(ListNode head) {
//        if(head==null || head.next==null){
//            return false;
//        }
//        ListNode slow=head;
//        ListNode fast=head;
//        while(fast.next!=null && fast.next.next !=null && fast.next.next!=null){
//            if(slow.next==fast.next.next.next){
//                return true;
//            }
//            slow=slow.next;
//            fast=fast.next.next;
//
//        }
//        return false;
//    }
//}
public class CycleInALinkedList {

 class ListNode {
     int val;
   ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
    public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }

        }
        return false;
    }
    public int  findLengthOfCyclicLinkedList(ListNode head) {

            if(head.next==null){
                return 1;
            }
            ListNode slow=head;
            ListNode fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(fast==slow){
                    ListNode temp=slow;
                    int length=0;
                    do {
                        temp=temp.next;
                        length++;
                    }while (temp!=slow);
                    return  length;
                }


            }
            return 0;
        }
    public ListNode  findStartOfCyclicLinkedList(ListNode head) {

            if(head.next==null){
                return null;
            }
            ListNode slow=head;
            ListNode fast=head;
            ListNode temp=head;
            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(fast==slow){
                    while(temp!=slow){
                        temp=temp.next;
                        slow=slow.next;
                    }
                    return slow;
                }





            }
            return null;
        }
}


}
