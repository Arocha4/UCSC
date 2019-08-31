//GCD.java
//Antoine Rocha
// pa3
// arocha4
// this progam takes two inputs and outputs two user inputs and outputs the GDC

 import java.util.Scanner;
 class GCD{
	
     public static void main( String[] args){
     int x,y,a,b,c,r;
     Scanner sc = new Scanner(System.in);
//////////////////////////////////////////////////////////////////////////////////////////
     
      System.out.print("Enter a postive integer: ");
      while (true) {
      while(!sc.hasNextInt()){
      sc.next();
      System.out.print("Please enter a positive integer: ");
      }
      x = sc.nextInt();
      if (x > 0){
      break;
      }
     if(x < 0){
      System.out.print("Please enter a positive integer:  ");
}
}
///////////////////////////////////////////////////////////////////////////////////////////       
      System.out.print("Enter another positive integer: ");
      while (true){
      while (!sc.hasNextInt()){
      sc.next();
      System.out.print("Enter another positive integer: ");
     }
     y = sc.nextInt();
     if (y > 0){
     break;
     }
     if (y < 0){
     System.out.print("Enter another positive integer: ");
     
}
}
      
//////////////////////////////////////////////////////////////////////////////////////////  
   

     if ( x > y){
     a = x;
     b = y;
    }  else {
   a = y;
   b = x;
}
  r = 1;
   while( r != 0){
    c = b;
    r = a%b;
   if ( r ==0 ){
    break;
}
    b = r;
    a = c; 	
    }
    System.out.println("The GCD of " +x+ " and " +y+ " is " + b);
    

   }
}
