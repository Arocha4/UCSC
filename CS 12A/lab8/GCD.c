/*
*Antoine Rocha
*arocha4
*lab8
this program takes two user inputs and finds the GCD
*/



//////////////////////////////////////////////////////////////////////////////////
#include<stdio.h>
#include<stdlib.h>
#include<string.h>  
#include<ctype.h>


//////////////////////////////////////////////////////////////////////////////////
int isInteger(char s[]){
   int i, n;
   
   if( s==NULL ) 
      return 0;
   n = strlen(s);
   if( n==0 ) 
      return 0;
   if( s[0]!='-' && s[0]!='+' && !isdigit(s[0]) )
      return 0;
   for(i=1; i<n; i++){
      if( !isdigit(s[i]) ) 
         return 0;
   }
   return 1;
}



 ///////////////////////////////////////////////////////////////////////////////////
 
 int main() {	
   int a, n, loop = 0, b, x, y, r, c;
   char str[200];
   printf("Enter a positive integer: ");
   while( loop < 1 ){	 
      n = scanf(" %s", str);
      if(loop < 1) {
      	  if( isInteger(str) ){           
        	sscanf(str, "%d", &x);
        	if(x < 0 || x == 0) {  
        		printf("Please enter a positive integer: ");
        		continue;
        	 }    
        	loop++;
        	printf("Please enter another positive integer: ");
          } else { printf("Please enter a positive integer: ");} 
      }
      while( loop == 1 ) {
      	n = scanf(" %s", str);
      	  if (isInteger(str) ) {
      	  	 sscanf(str, "%d", &y);
      	  	 if(y < 0 || y == 0) {  
        		printf("Please enter a positive integer: ");
        		continue;
        	 }
        	 loop++;
         } else { printf("Please enter a positive integer: ");} 

      } 
    }
   if (x > y) {
			a = x;
			b = y;
		   } else  {
		   a = y;
		   b = x;
		   }
		r = 1;
		while( r != 0) {
			c = b;
			r = a%b;
			if ( r == 0) {
				break;
			}
			b = r;
			a = c;
		}
		
		printf("The GCD of %d and %d is %d\n", x, y, b);
 } 
