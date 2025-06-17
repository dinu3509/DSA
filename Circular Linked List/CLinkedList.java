import java.util.*;

class Node {
    int data;
    Node next;

    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head, tail;

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void insertAtPosition(int value, int position) {
        if (position <= 0) {
            System.out.println("Invalid Position");
            return;
        }

        if (position == 1) {
            insertAtBeginning(value);
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count != position - 1) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }
    }

    public void delAtBeginning() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        tail.next = head;
    }

    public void delAtEnd() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
    }

    public void delAtPosition(int position) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        if (position == 1) {
            delAtBeginning();
            return;
        }

        Node temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (temp.next == head || temp.next == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void reverse() {
        if (head == null || head.next == head) {
            return; // 0 or 1 element
        }

        Node prev = tail;
        Node current = head;
        Node next;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        head = prev;
        tail = current;
    }
}

public class CLinkedList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CircularLinkedList cl = new CircularLinkedList();

        while (true) {
            System.out.println("\n--- Circular Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Beginning");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display");
            System.out.println("8. Reverse");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int ch = in.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    cl.insertAtBeginning(in.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    cl.insertAtEnd(in.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value and position: ");
                    int val = in.nextInt();
                    int pos = in.nextInt();
                    cl.insertAtPosition(val, pos);
                    break;
                case 4:
                    cl.delAtBeginning();
                    break;
                case 5:
                    cl.delAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    cl.delAtPosition(in.nextInt());
                    break;
                case 7:
                    cl.display();
                    break;
                case 8:
                    cl.reverse();
                    System.out.println("List reversed.");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
