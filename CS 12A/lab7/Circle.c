#include<stdio.h>
#include<math.h>

double  main(){
   double radius, area, circumference;
   const double pi = 3.141592654;

   printf("Enter radius: ");
   scanf("%lf", &radius);
   area = pi*pow(radius,2);
   circumference = 2*pi*radius;
   printf("The area is: %f\n", area);
   printf("The circumference is: %f\n", circumference);

   return 0;
}
