// Antoine Rocha
// arocha4
// Cmps12b pa4
// QueueTest.java


public class QueueTest{
	public static void main(String[] arg){
		Queue A = new Queue();
		
		System.out.println(A.isEmpty());
		//inserts
		A.enqueue(0);
		A.enqueue(1);
		A.enqueue(2);
		A.enqueue(3);
		A.enqueue(4);
		A.enqueue(5);
		System.out.println(A.length());
		
		//deletes all
		A.dequeue();
		A.dequeue();
		System.out.println(A.isEmpty());
		System.out.println(A.length());
		System.out.println("A contains: " + A);
		
		//inserts
		A.enqueue(100);
       
	   // deletes        
		A.dequeue();
		System.out.println("A contains: " + A);

		//s report true
		System.out.println("A empty: " + A.isEmpty() );
		A.enqueue(200);

		//should report false
		System.out.println(" false added 200  Retesting  A.Empty() " + A.isEmpty() );
		
		//length
		System.out.println("should be 1 Size/Length of A: " + A.length() );

		System.out.println("Enqueueing");
		A.enqueue(100);
		A.enqueue(200);

		//peek should be 1
		System.out.println("Peek of A: " + A.peek() );

		//print nothing
		A.dequeueAll();
		System.out.println("Dequeueing All. A contains: "  + A);
		
		
//Thank you T.A grading does get repatitve and hopefilly this makes the process easier.
	    System.out.println("Thank you for your time.");
		System.out.println("And have a nice weekend.");
	}
}