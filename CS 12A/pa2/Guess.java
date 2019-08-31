// Antoine Rocha
// arocha4
// Guess.java
// this program is a guessing game and interacts with the user.
///////////////////////////////////////////////////////////////////////////////////
  import java.util.Scanner;
  class Guess{
	 
   public static void main( String[] args){
   Scanner sc = new Scanner(System.in);
   int random = (int)(Math.random()*10+1);
//////////////////////////////////////////////////////////////////////////////////
    System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses. " );
    System.out.println("");
    System.out.print(" Enter your first guess: ");
    int guess = sc.nextInt();
////////////////////////////////////////////////////////////////////////////////
  
      if (random > guess) { 
      System.out.println(" Your guess is too low.");
   
}
     else if(random < guess) {
     System.out.println(" Your guess is too high.");
}
     else{
     System.out.println(" You win!");
     System.exit(0);
}
//////////////////////////////////////////////////////////////////////////////////
    System.out.println("");
    System.out.print(" Enter your second guess: ");
   int guess2 = sc.nextInt();
//////////////////////////////////////////////////////////////////////////////////

    if (random > guess2) {
     System.out.println(" Your guess is too low. ");

}
     else if(random < guess2) {
     System.out.println(" Your guess is too high. ");
}
    else{
     System.out.println(" You win! ");
      System.exit(0);
}
/////////////////////////////////////////////////////////////////////////////////

    System.out.println(" ");
     System.out.print(" Enter your third guess: ");
     int guess3 = sc.nextInt();
///////////////////////////////////////////////////////////////////////////////

    if (random > guess3) {
     System.out.println(" Your guess is too low. ");

}
    else if(random < guess3) {
    System.out.println(" Your guess is too high. ");
}
    else{
    System.out.println(" You win! ");
    System.exit(0);
} 
//////////////////////////////////////////////////////////////////////////////
   System.out.println("");
   System.out.print(" You lose. The number was " + random);
   System.out.println("");
   System.exit(0);

}
}

