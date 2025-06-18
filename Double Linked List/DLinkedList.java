import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class DoublyLinkedList {
    private Node head, tail;

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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

        Node temp = head;
        int count = 1;
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            insertAtEnd(value);
            return;
        }

        Node newNode = new Node(value);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void delAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void delAtEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void delAtPosition(int position) {
        if (position <= 0 || head == null) {
            System.out.println("Invalid or empty list");
            return;
        }

        if (position == 1) {
            delAtBeginning();
            return;
        }

        Node temp = head;
        int count = 1;
        while (count < position && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (temp == tail) {
            delAtEnd();
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Forward: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Backward: ");
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public void reverseList() {
        if (head == null) return;

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        // Recalculate tail
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
    }
}

public class DoublyList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        while (true) {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Beginning");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Backward");
            System.out.println("9. Reverse List");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int ch = in.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    dll.insertAtBeginning(in.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    dll.insertAtEnd(in.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value and position: ");
                    dll.insertAtPosition(in.nextInt(), in.nextInt());
                    break;
                case 4:
                    dll.delAtBeginning();
                    break;
                case 5:
                    dll.delAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    dll.delAtPosition(in.nextInt());
                    break;
                case 7:
                    dll.displayForward();
                    break;
                case 8:
                    dll.displayBackward();
                    break;
                case 9:
                    dll.reverseList();
                    System.out.println("List reversed.");
                    break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
