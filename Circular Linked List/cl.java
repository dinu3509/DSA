import java.util.*;

class Node{
    int data;
    Node next;
    Node(int value){
        this.data = value;
        this.next = null;
    }
}

class CircularLinkedList{
    private Node head,tail;

    public void insertAtBeginning(int value){
        Node newNode = new Node(value);

        if(head==null){
            head=tail=newNode;
        }
        else{
            tail.next = newNode;
            newNode.next=head;
            head=newNode;
        }
    }
    public void insertAtEnd(int value){
        Node newNode = new Node(value);
        if(head==null){
            head=tail=newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

    }

    public void insertAtPosition(int value,int position){
        if(position<=0){
            System.out.println("Invalid Position");
            return;
        }
        Node newNode = new Node(value);
        Node temp=head;
        int count = 1;
        while(count<position-1 && temp.next!=head){
            temp = temp.next;
            count++;
        }
         if (count != position - 1) {
        System.out.println("Invalid position");
        return;
    }
       
newNode.next = temp.next;
    temp.next = newNode;

    // If inserting at end, update tail
    if (temp == tail) {
        tail = newNode;
    }

    }
}
public class cl {

    
}
