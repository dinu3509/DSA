import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head, tail;

        public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
    }
    
     public void insertAtPosition(int position, int value) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(value);

        if (position == 1) {
            insertAtBeginning(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    

    public void display() {
        Node temp = head;
        System.out.print("Linked list contents: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice;

        do {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at specific position");
            System.out.println("4. Display list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int value, position;
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    value = sc.nextInt();
                    list.insertAtBeginning(value);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    value = sc.nextInt();
                    list.insertAtEnd(value);
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    System.out.print("Enter value to insert at position " + position + ": ");
                    value = sc.nextInt();
                    list.insertAtPosition(position, value);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 5);

        sc.close();
    }
}
