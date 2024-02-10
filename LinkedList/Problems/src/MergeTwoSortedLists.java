//https://leetcode.com/problems/merge-two-sorted-lists/submissions/1171691561/
public class MergeTwoSortedLists {

    public class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value=value;
        }
    }
    //Merge sort linked list using Extra Space
    //Two Pointer Approach
    public ListNode MergeTwoSortedLinkedListUsingExtraSpace(ListNode A,ListNode B){
        ListNode temp1=A;
        ListNode temp2=B;
        ListNode MergedListHead=new ListNode(100);
        ListNode temp=MergedListHead;
        while(temp1.next!=null && temp2!=null){
               if(temp1.value< temp2.value){
                   ListNode nextNode=new ListNode(temp1.value);
                   temp.next=nextNode;
                   temp=nextNode;
                   temp1=temp1.next;
               }
               else{
                   ListNode nextNode=new ListNode(temp2.value);
                   temp.next=nextNode;
                   temp=nextNode;
                   temp2=temp2.next;
               }
        }
        if(temp1==null){
            temp.next=temp2;
        }
        else{
            temp.next=temp1;
        }
        return  MergedListHead.next;
    }
    public  ListNode MergeTwoSortedLinkedListWithConstantspace(ListNode list1,ListNode list2){
        ListNode temp1=list1;
        ListNode temp2=list2;
        ListNode MergedListHead=new ListNode(100);
        ListNode temp=MergedListHead;
        while(temp1!=null && temp2!=null){
            if(temp1.value<temp2.value){
                temp.next=temp1;
                temp=temp1;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp=temp2;
                temp2=temp2.next;
            }
        }
        if(temp1==null){
            temp.next=temp2;
        }
        else{
            temp.next=temp1;
        }
        return MergedListHead.next;
    }


}
