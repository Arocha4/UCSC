// Antoine Rocha
// arocha4
// Cmps12M 
//lab6
// List.java
@SuppressWarnings("overrides")
public class List < L > implements ListInterface < L > {

    private class Node {

        //fields for Node
        L item;
        Node next;
        Node(L x) {
            item = x;
            next = null;
        }
    }
    private Node head;
    private int numItems;

    //constructor for List class
    public List() {
        head = null;
        numItems = 0;
    }

    //find()
    private Node find(int index) {
        Node H = head;
        for (int j = 1; j < index; j++) {
            H = H.next;
        }
        return H;
    }

    //add()
    //pre: 1 <= index <= size()+1
    public void add(int index, L newItem) throws ListIndexOutOfBoundsException {
        if (index < 1 || index > (numItems + 1)) {
            throw new ListIndexOutOfBoundsException(
                "Error: add() invalid index: " + index);
        }
        if (index == 1) {
            Node H = new Node(newItem);
            H.next = head;
            head = H;
        } else {
            Node Pre = find(index - 1);
            Node A = Pre.next;
            Pre.next = new Node(newItem);
            Pre = Pre.next;
            Pre.next = A;
        }
        numItems++;
    }

    //get()
    //pre: 1 <= index <= size()
    public L get(int index) throws ListIndexOutOfBoundsException {
        if (index < 1 || index > numItems) {
            throw new ListIndexOutOfBoundsException(
                "List Error: get() called on invalid index: " + index);
        }
        Node H = find(index);
        return H.item;
    }



    // equals()    
    @SuppressWarnings("unchecked")
    public boolean equals(Object Right_Hand_Side) {
        boolean equal = false;
        List < L > Right = null;
        Node H = null;
        Node I = null;

        if (this.getClass() == Right_Hand_Side.getClass()) {
            Right = (List < L > ) Right_Hand_Side;
            equal = (this.numItems == Right.numItems);

            H = this.head;
            I = Right.head;
            while (equal && H != null) {
                equal = (H.item == I.item);
                H = H.next;
                I = I.next;
            }
        }
        return equal;
    }

    //remove()
    //pre: 1 <= index <= size()
    public void remove(int index) throws ListIndexOutOfBoundsException {
        if (index < 1 || index > numItems) {
            throw new ListIndexOutOfBoundsException(
                "Error: remove() - invalid index: " + index);
        }
        if (index == 1) {
            Node H = head;
            head = head.next;
            H.next = null;
        } else {
            Node Pre = find(index - 1);
            Node H = Pre.next;
            Pre.next = H.next;
            H.next = null;
        }
        numItems--;
    }

    // toString()
    public String toString() {
        StringBuffer Tor = new StringBuffer();
        Node H = head;

        for (; H != null; H = H.next) {
            Tor.append(H.item).append(" ");
        }
        return new String(Tor);
    }

    //isEmpty()
    public boolean isEmpty() {
        return (numItems == 0);
    }

    //removeAll()
    public void removeAll() {
        head = null;
        numItems = 0;
    }
    //size()
    public int size() {
        return numItems;
    }
}