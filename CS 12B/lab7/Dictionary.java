// Antoine Rocha
// arocha4
// Cmps12M
// Lab7
// Dictionary.java
public class Dictionary implements DictionaryInterface {

    // Node()
    private class Node {
        String key;
        String value;
        Node left;
        Node right;

        // constructor for the private Node class
        Node(String S, String word) {
            key = S;
            value = word;
            right = null;
            left = null;
        }
    }

    private Node Head;
    private int NumberOfItems;

    // Dictionary()
    public Dictionary() {
        Head = null;
        NumberOfItems = 0;
    }


    // delete()
    public void delete(String key) throws KeyNotFoundException {
        Node H = findKey(Head, key);
        Node Par, S;
        if (lookup(key) == null) {
            throw new KeyNotFoundException("cannot delete non-existent key");
        }
        if (H.left == null && H.right == null) {
            if (H == Head) {
                Head = null;
            } else {
                Par = findParent(H, Head);
                if (Par.right == H) {
                    Par.right = null;
                } else {
                    Par.left = null;
                }
            }
        } else if (H.right == null) {
            if (H == Head) {
                Head = H.left;
            } else {
                Par = findParent(H, Head);
                if (Par.right == H) {
                    Par.right = H.left;
                } else {
                    Par.left = H.left;
                }
            }
        } else if (H.left == null) {
            if (H == Head) {
                Head = H.right;
            } else {
                Par = findParent(H, Head);
                if (Par.right == H) {
                    Par.right = H.right;
                } else {
                    Par.left = H.right;
                }
            }
        } else {
            S = findLeftmost(H.right);
            H.key = S.key;
            H.value = S.value;
            Par = findParent(S, H);
            if (Par.right == S) {
                Par.right = S.right;
            } else {
                Par.left = S.right;
            }
        }
        NumberOfItems--;
    }


    // insert()
    public void insert(String key, String value) throws DuplicateKeyException {

        Node H, X, Y;
        if (lookup(key) != null) {
            throw new DuplicateKeyException("cannot insert duplicate keys");
        }
        H = new Node(key, value);
        Y = null;
        X = Head;
        while (X != null) {
            Y = X;
            if (key.compareTo(X.key) < 0) {
                X = X.left;
            } else {
                X = X.right;
            }
        }
        if (Y == null) {
            Head = H;
        } else if (key.compareTo(Y.key) < 0) {
            Y.left = H;
        } else {
            Y.right = H;
        }
        NumberOfItems++;
    }


    // fineKey()
    private Node findKey(Node Right, String key) {
        if (Right == null || Right.key.compareTo(key) == 0) {
            if (Right == null) {
                return null;
            } else {
                return Right;
            }
        }
        if (Right.key.compareTo(key) > 0) {
            return findKey(Right.left, key);
        } else {
            return findKey(Right.right, key);
        }
    }

    // findParent()
    private Node findParent(Node H, Node Right) {
        Node Parent = null;
        if (H != Right) {
            Parent = Right;
            while (Parent.left != H && Parent.right != H) {
                if (H.key.compareTo(Parent.key) < 0) {
                    Parent = Parent.left;
                } else {
                    Parent = Parent.right;
                }
            }
        }
        return Parent;
    }

    // findLeftmost()
    private Node findLeftmost(Node Right) {
        Node Left = Right;
        if (Left != null) {
            for (; Left.left != null; Left = Left.left) {}
        }
        return Left;
    }

    // printInOrder()
    private String printInOrder(Node Right) {
        String space = "";
        int count = 0;
        if (Right != null) {
            printInOrder(Right.left);
            System.out.println(Right.key + " " + Right.value);
            printInOrder(Right.right);
        }
        return "";
    }

    //lookup()
    public String lookup(String key) {
        Node FK = findKey(Head, key);
        if (Head == null) {
            return null;
        }
        if (FK == null) {
            return null;
        } else {
            return FK.value;
        }
    }

    //MakeEmpty()
    public void makeEmpty() {
        Head = null;
        NumberOfItems = 0;
    }

    // toSting()
    public String toString() {
        Node H = Head;
        return printInOrder(H);
    }

    // isEmpty()
    public boolean isEmpty() {
        return (NumberOfItems == 0);
    }

    //Size()     
    public int size() {
        return NumberOfItems;
    }


}