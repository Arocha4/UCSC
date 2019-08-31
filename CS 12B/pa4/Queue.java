// Antoine Rocha
// arocha4
// Cmps12b pa4
// Queue.java
//////////////////////////////////////////////////////////////////////////////////////////
public class Queue implements QueueInterface{

   private class Node{

		//fields for Node
		Object item;
		Node next;

		//constructor for Node
		Node(Object item){
			this.item = item;
			next = null;
		}
	}

	//fields for Queue
      private Node Head;
      private int NumOfItems;

	//constructor for Queue
      public Queue(){
		Head = null;
		NumOfItems = 0;
	}

////////////////////////////////////////////////////////////////////////////////////////////

	
	// length()
	//tells the size of the Queue
	public int length(){
		return NumOfItems;
	}
	
	/*peek
   *Pre: the Queue can not be empty 
   */
	public Object peek() throws QueueEmptyException{
		if( Head == null ){
			throw new QueueEmptyException(
				" Erroe peek():  empty queue.");
		}
		else{
			return Head.item;
		}
	}
	
	/*isEmpty()
   *Pre:none
   */
	public boolean isEmpty(){
		return NumOfItems == 0;
	}
	
	/*enqueue
   *Pre:None 
   */ 
	public void enqueue(Object newItem){
		
		if( Head == null ){
			Head = new Node(newItem); 
		}
		
		else{
			Node H = Head;
			while( H.next != null ){
				H = H.next;
			} 
			H.next = new Node(newItem);
		}
		NumOfItems++;
	}

	
     /*toString
   *Pre:none 
   */
	public String toString(){
		String space = "";
		Node H = Head;
		while( H != null ){
			space = space + H.item + " ";
			H = H.next;
		}
		return space;
	}
    
	 /*dequeue
   *Pre: the Queue can not be empty  
   */
	public Object dequeue() throws QueueEmptyException{
		if( Head == null ){
			throw new QueueEmptyException(
				"Error dequeue() error: empty queue.");
		}
		else{
			Node H = Head;
			Head = H.next;
			NumOfItems--;
			return H.item;
		}
	}
	
	 /*dequeueAll
   *Pre: the Queue can not be empty 
   */
	public void dequeueAll() throws QueueEmptyException{
		if( Head == null ){
			throw new QueueEmptyException(
				"error dequeueAll(): empty queue.");
		
		}
		else{
			Head = null;
			NumOfItems= 0;
		}
	}
}