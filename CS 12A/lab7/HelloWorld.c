/* HelloWorld.c  */
#include<stdio.h>
#include<stdlib.h>
int main(void){
 int n, i;
 double x[3];
 printf("Enter three doubles separated by ");
 printf("spaces, then press return: ");
 n = scanf(" %lf %lf %lf", &x[0], &x[1], &x[2]);
 printf("%d numbers were successfully read: ", n);
 for(i=0; i<n; i++){
 printf("%f ", x[i]);
 }
 printf("\n");

 return 0;
}

