//Antoine Rocha
//arocha4	
//cmps12b
//DictionaryTest.java test ADT ops

class DictionaryTest {
    public static void main(String[] args) {
        Dictionary test = new Dictionary();

        /////////////////////////////////////////////////////////////////////////////////////////

        //test isEmpty()
        System.out.println("True or false is the dictionary empty ? " + test.isEmpty());

		/////////////////////////////////////////////////////////////////////////////////////////

		//check case adding and deleting the first node.
        test.insert("1234", "z");
        test.delete("1234");

        System.out.println("Dictionary contains : " + test);
        // contains nothing
        /////////////////////////////////////////////////////////////////////////////////////////

        //testing insert() to an existing dictionary
        test.insert("21", "z");
        test.insert("20", "y");
        test.insert("7", "x");
        System.out.println("Dictionary contains : " + test);
        // contains 21, 20, 7 
        //////////////////////////////////////////////////////////////////////////////////////////		

        //testing delete() to multiple elements 
        test.delete("21");
        test.delete("20");
        System.out.println("Dictionary contains :" + test);
        // contains 7
        ///////////////////////////////////////////////////////////////////////////////////////

        //test lookup and insert isEmpty() & test lookup()
        System.out.println("Is the Dictionary empty ? " + test.isEmpty());

        test.insert("1", "c");
        test.insert("2", "e");

        System.out.println("Dictionary contains :" + test);

        test.delete("2");

        if (test.lookup("2") == null)
            System.out.println("test.lookup(2) failed.");

        if (test.lookup("1") != null)
            System.out.println("test.lookup(1) worked.");

        ////////////////////////////////////////////////////////////////////////////////////////

        //test makeEmpty and size()
        test.makeEmpty();
        System.out.println("deleted dictionary");
        System.out.println("True flase, is the dictionary empty ?  " + test.isEmpty());
        System.out.println("Dictionary size: " + test.size());
        System.out.println("Inserting and testing size");
        test.insert("1", "a");
        test.insert("2", "b");
        test.insert("3", "c");

        System.out.println("Inserted " + test.size() + " to dictionary.");
        System.out.println("size(): " + test.size());

        /////////////////////////////////////////////////////////////////////////////////////////
        //testing Exceptions,but do not throw it.
        try {
            test.insert("4", "a");
        } catch (DuplicateKeyException e) {
            System.out.println(e + "proceeding" );
            }

            try {
                test.delete("1234567890");
            } catch (KeyNotFoundException e) {
                System.out.println(e + "proceeding");
            }
			/////////////////////////////////////////////////////////////////////////////////////////


            System.out.println("ADT ops tested. Thank you for time and have a nice day.");
        }
    }
