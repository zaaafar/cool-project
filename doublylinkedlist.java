class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty. No node to delete");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty. No node to delete");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                if (temp == head) {
                    deleteFirst();
                } else if (temp == tail) {
                    deleteLast();
                } else {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Node with value " + value + " not found");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
    System.out.println("Name: Zaid Patel");
    System.out.println("Roll No.: MCA - 40");
        DoublyLinkedList list = new DoublyLinkedList();


        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);

        System.out.println("List after inserting at beginning:");
        list.displayForward(); 


        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.println("List after inserting at end:");
        list.displayForward(); 
  
        list.deleteFirst();
        System.out.println("List after deleting first node:");
        list.displayForward(); 

        list.deleteLast();
        System.out.println("List after deleting last node:");
        list.displayForward();

        list.delete(20);
        System.out.println("List after deleting node with value 20:");
        list.displayForward();  

        System.out.println("List in reverse order:");
        list.displayBackward(); 
    }
}
