// Antoine Rocha
//arocha4
//cmps12b 
//Dictionary.java 
//implements DictionaryInterface.java

public class Dictionary implements DictionaryInterface {

    //global fields for the Dictionary 
    private Node H;
    private int NumberOfItems;




    //makeEmpty()
    public void makeEmpty() {
        H = null;
        NumberOfItems = 0;
    }



    //isEmpty()
    public boolean isEmpty() {
        return (NumberOfItems == 0);
    }





    //constructor for Dictionary class
    public Dictionary() {
        H = null;
        NumberOfItems = 0;
    }



    //size();
    public int size() {
        return NumberOfItems;
    }



    //toString()
    public String toString() {
        String string = "";
        Node N = H;

        while (N != null) {
            string = string + N.Key + " " + N.Val + "\n";
            N = N.next;
        }
        return string;
    }



    //private inner Node class
    private class Node {
        String Val;
        String Key;
        Node next;

        Node(String a, String b) {
            Key = a;
            Val = b;
            next = null;
        }
    }




    //lookup(String Key);
    public String lookup(String a) {
        Node N = H;
        while (N != null) {
            if (N.key.equals(a))
                return N.Val;
            else
                N = N.next;
        }
        return null;
    }





    //findKey(String Key)
    private Node findKey(String a) {
        Node N = H;
        while (N != null) {
            if (N.Key != a)
                N = N.next;
            else
                return N;
        }
        return null;
    }






    //insert(String a, String b) inserts a new node at the enIn
    public void insert(String a, String b) throws DuplicateKeyException {
        Node N = H;
        Node swap = new Node(a, b);

        //determine if there isn't already a Key in this node
        if (lookup(a) != null) {
            throw new DuplicateKeyException("Cannot insert duplicate keys. lnsert(String a, String b");
        }

        //make special case for empty dictionary
        if (H == null) {
            H = swap;
        } else {
            //run to the node before the last one.
            while (N != null) {
                if (N.next == null)
                    break;
                N = N.next;
            }

            N.next = swap;
        }

        NumberOfItems++;
    }






    //delete(String Key)
    //pre-conditon: Dictionary must contain the argument Key
    public void delete(String a) throws KeyNotFoundException {
        Node N = H;

        //check if such Key exists, if not throw an exception
        if (lookup(a) == null)
            throw new KeyNotFoundException("Can't delete a string that doesnt exist. delete(String a)");

        else {
            //special case for one node. deletes only if there is one node
            if (NumberOfItems <= 1) {
                H = H.next;
                N.next = null;
            } else if (N.Key.equals(a)) {
                H = N.next;
            }
            //else, run to the node before Key node.
            else {
                while (!N.next.Key.equals(a))
                    N = N.next;
                N.next = N.next.next;
            }
        }
        NumberOfItems--;
    }
}
