public class SortList {
     public static class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            this.val=data;
        }
    }
    public ListNode BubbleSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }
        ListNode numbers=head;
        ListNode temp;
        while(numbers!=null){
            temp=head;
            while(temp.next!=null){
                if(temp.val>temp.next.val){
                    int tempSwapped=temp.next.val;
                    temp.next.val=temp.val;
                    temp.val=tempSwapped;
                }
                temp=temp.next;
            }
            numbers=numbers.next;
        }
        return head;
    }
    public ListNode InsertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }
        // Initialize a dummy node to simplify insertion at the beginning
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = head;
        ListNode prev = dummy;
        while (current != null) {
            ListNode nextNode = current.next;

            // Find the correct position to insert the current node in the sorted portion
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert the current node after 'prev'
            current.next = prev.next;
            prev.next = current;

            // Move to the next unsorted node
            current = nextNode;

            // Reset 'prev' to the dummy node for the next iteration
            prev = dummy;
        }

        return dummy.next;  // The sorted linked list starts from the next of the dummy node
    }
    public ListNode QuickSortList(ListNode head) {
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode tail) {
        if(head == null || head.next == null || head == tail) {
            return head;
        }

        boolean sorted = true;
        ListNode pivot = head;
        ListNode curr = pivot.next;
        ListNode prev = pivot;
        while(curr != null && curr != tail) {
            ListNode next = curr.next;

            if(curr.val < pivot.val) {
                sorted = false;
                prev.next = next;
                curr.next = head;
                head = curr;
            } else {
                if(curr.val < prev.val) {
                    sorted = false;
                }
                prev = curr;
            }
            curr = next;
        }

        if(sorted) {
            return head;
        }

        pivot.next = quickSort(pivot.next, tail);
        return quickSort(head, pivot);
    }
}
