/* antoine rocha
 * arocha4
 * lab7
 * this program takes radius input and gives volume and surface area
 * */
#include<stdio.h>
#include<math.h>

int main(){
   double radius, volume, sarea;
   const double pi = 3.141592654;
   printf("Enter radius: ");
   scanf("%lf", &radius);
   volume = 4*pi*pow(radius,3)/3;
   sarea = pi*pow(radius,2)*4 ;
   printf("The volume is: %f", volume) ;
   printf(" and the Surface Area is: %f\n", sarea) ;

   return 0;
}
