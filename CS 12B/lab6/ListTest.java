// Antoine Rocha
// arocha4
// Cmps12M 
//lab6
// ListTest.java
// Test file for List.java

class ListTest{
    public static void main(String[] args){
        List<String> S = new List<String>();
        List<Integer> I = new List<Integer>();

        S.add(1, "Mr");
        S.add(2, "Miss");
        S.add(3, "Sir");
		S.add(4, "Madam");
        System.out.println("testing nums");
		System.out.println("S size() :" +S.size());
        I.add(1, 10);
        I.add(2, 20);
        I.add(3, 30);
		I.add(4, 40);
        System.out.println("\n" + S.toString());
        System.out.println("printing nums" + "\n");
        System.out.println(I.toString());
		System.out.println("I size() :" +I.size());
        S.remove(2);
		System.out.println("remove Miss");
        I.remove(3);
		System.out.println("remove 30");
		System.out.println("I size() :" +I.size());
        System.out.println(S.equals(I));
        System.out.println(S.toString());
        System.out.println(I.toString());
        System.out.println("does S and I equal eachother :"S.equals(I));
	}
	
}