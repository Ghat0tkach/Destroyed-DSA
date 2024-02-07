public class LinkedList {
    //Nodes are just references pointing
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.size=0;
    }
    public void insertFist(int val){
        Node node= new Node(val);
        node.next=head;
        head=node;

        if(tail==null) {
            tail = head;
        }
        size+=1;
    }
    public void insertAtEnd(int val){
        Node temp=new Node(val);
        if(head==null){
            head=temp;
            tail=temp;
        }
        tail.next=temp;
        tail=temp;

    }
    public void insertAtAnyIndex(int val,int index){
          Node temp=new Node(val);
          Node travel=head;
          if(index==size()){
              insertAtEnd(val);
              return;
          }
          if(index==0){
              insertFist(val);
              return;
          }
          for(int i=1;i<=index-1;i++){
              travel=travel.next;
          }
          temp.next=travel.next;
          travel.next=temp;
    }
    public void deleteAtAnyIndex(int index){
        Node temp=head;
        for (int i = 0; i < index; i++) {

            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
    int getAt(int index){
        Node temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp.value;
    }
    int size(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value + "=>");
            temp=temp.next;
        }
        System.out.println("End ");
    }

    private class  Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
        public  Node(int value, Node next){
            this.value=value;
            this.next=next;
        }
    }
}
