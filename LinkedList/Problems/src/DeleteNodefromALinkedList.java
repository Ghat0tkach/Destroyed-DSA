//https://leetcode.com/problems/delete-node-in-a-linked-list
public class DeleteNodefromALinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

//Question answer approach
//Node value gets deleted not the node itself
//The code does not delete the memory occupied by the specified node. Instead, it effectively "deletes" the value in the given node by copying the value from the next node, and then it adjusts the pointers so that it skips the node to be "deleted."
//
//Here's a step-by-step breakdown of the process:
//
//Copy the value of the next node to the current node: node.val = node.next.val.
//Update the ///////////
//1->2->3->4->5
//suppose the node which im deleting is 3
//then node.value=node.next.value will result in 1->2->4->4->5

// to skip the next node and point directly to the node after it: node.next = node.next.next.
//After these steps, the value of the specified node has been replaced with the value from the next node, and the next pointer has been adjusted to effectively "skip" the next node in the linked list.
//node.next=node.next.next will result in 1->2->4->5
//In terms of memory, the memory occupied by the specified node remains allocated, but its contents have been modified. The node that was originally after it is effectively skipped, and the linked list structure is adjusted accordingly.