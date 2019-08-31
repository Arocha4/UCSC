//-----------------------------------------------------------------------------
// Antoine Rocha
// arocha4@ucsc.edu
//Recursion.java pa1
//6/30/2017
// Recursion.java
// This program reverses the output of the given array and gives the min and max
// index's
//-----------------------------------------------------------------------------

class Recursion {
   
   // reverseArray1()
   // Places the leftmost n elements of X[] into the rightmost n positions in
   // Y[] in reverse order
   static void reverseArray1(int[] X, int n, int[] Y){  // n = X.length

         if(n>0) {                    // do nothing if n=0                 
           
           Y[n-1] = X[X.length-n];    // copy left index of X to right Y
             
            reverseArray1(X,n-1,Y);    // recure till n=1 		
	 }
	 
	 
   }

   // reverseArray2()
   // Places the rightmost n elements of X[] into the leftmost n positions in
   // Y[] in reverse order.
   static void reverseArray2(int[] X, int n, int[] Y){
	   
          if( n>0 ){                           // if n=0 do nothing cylve down ward
          
           Y[X.length-n]=X[n-1];               // copy right of X into left Y 
	   
            reverseArray2(X, n-1,Y);         // recue until n =1

                   

     }
   
}

   
   // reverseArray3()
   // Reverses the subarray X[i...j].
   static void reverseArray3(int[] X, int i, int j){
	  
           int A = X.length;             // declare varibles
           int a, b;                     // temp varibles

              if(j > A/2) {             // recure to midpont
             
                a = X[j];              // copy element into temp vaible
                b = X[i];              // copy element into temp varible
                X[i] = a;              // paste temp varible into reversed array
                X[j] = b;              // paste temp varible into reversed array
                      
                 reverseArray3(X,i+1, j-1);     // recure till midpoint
      
   }
   
}
   // maxArrayIndex()
   // returns the index of the largest value in int array X
   static int maxArrayIndex(int[] X, int p, int r){      // p =0, r=A.length-1
            
         int q;                                   // q = midpoint
         if(p < r) {                             // if left is less than right index
      
          q = (p+r)/2;                                // midpoint
          int L = maxArrayIndex(X, p, q);                // left array  most left indexd
          int R = maxArrayIndex(X, q+1, r);              // right array most left index
               
                 if( X[L] > X[R])                       // compare index's 
	           return L;                            // return L if L>R index
		
		 else                                  // return R is not true
		   return R;
		 }     
    		  else                                 // or return the smallest value
                   return p;

     }    


       
   
   // minArrayIndex()
   // returns the index of the smallest value in int array X
   static int minArrayIndex(int[] X, int p, int r){
     
      int q;                          // declare midpoint
       if (p<r) {                     // control 
	  

        q = (p+r)/2;                         // midpoint
        int L = minArrayIndex(X,p,q);        // left midpoint
	int R = minArrayIndex(X,q+1,r);      // right midpoint  
	   

           if(X[L]< X[R])                   // compare index locations
	       return L;                    // return L
	   else
	  	return R;                   // else return R
	   }
	   else 
		return p;     	            // else return p

     }  
   // main()
   public static void main(String[] args){
      
      int[] A = {-1,2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
      int[] B = new int[A.length];
      int[] C = new int[A.length];
      int minIndex = minArrayIndex(A, 0, A.length-1);
      int maxIndex = maxArrayIndex(A, 0, A.length-1);
 

      for(int x: A) System.out.print(x+" ");
      System.out.println(); 
      
      System.out.println( "minIndex = " + minIndex );  
      System.out.println( "maxIndex = " + maxIndex );  

      reverseArray1(A, A.length, B);
      for(int x: B) System.out.print(x+" ");
      System.out.println();
      
      reverseArray2(A, A.length, C);
      for(int x: C) System.out.print(x+" ");
      System.out.println();
      
      reverseArray3(A, 0, A.length-1);
      for(int x: A) System.out.print(x+" ");
      System.out.println();  
      
   }
   
}
/* Output:
-1 2 6 12 9 2 -5 -2 8 5 7
minIndex = 6
maxIndex = 3
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
*/
