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

    public void deleteAtBeginnning() {
        if (head == null) {
            System.out.println("The Linked List is Empty");
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            System.out.println("Deleted node: " + temp.data);
            if (head == null) {
                tail = null;
            }
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("The Linked List is Empty");
        } else if (head.next == null) {
            System.out.println("Deleted node: " + head.data);
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            System.out.println("Deleted node: " + tail.data);
            temp.next = null;
            tail = temp;
        }
    }

    public void deleteAtPosition(int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }
        if (position == 1) {
            System.out.println("Deleted node: " + head.data);
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        Node prev = head;
        for (int i = 1; i < position - 1 && prev.next != null; i++) {
            prev = prev.next;
        }
        if (prev.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        Node toDelete = prev.next;
        System.out.println("Deleted node: " + toDelete.data);
        prev.next = toDelete.next;
        if (toDelete == tail) {
            tail = prev;
        }
        toDelete.next = null;
    }

    public void reverse() {
        if (head == null) {
            System.out.println("The Linked List is empty.");
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        tail = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("Linked List has been reversed.");
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
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete at specific position");
            System.out.println("7. Reverse the list");
            System.out.println("8. Display list");
            System.out.println("9. Exit");
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
                    list.deleteAtBeginnning();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    position = sc.nextInt();
                    list.deleteAtPosition(position);
                    break;
                case 7:
                    list.reverse();
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 9);

        sc.close();
    }
}
