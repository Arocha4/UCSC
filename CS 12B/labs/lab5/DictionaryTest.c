// Antoine Rocha
// arocha4
// Cmps12M
// Lab 5
// DictionaryTest.c 
// a test for the ADT ops






#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

int main(int argc, char* argv[]){
    
	Dictionary A = newDictionary();
    printf( "Dictionary Empty: %d\n", isEmpty(A) );
	FILE* out = fopen("DictionaryTest-out", "w");
    char* key = " Morning";
    char* value = "I";
    char* key2 = "Have";
    char* val2 = "crippling";
    char* key3 = "depression";
    char* val3 = "Help";
	char* key4 = "sorry";
	char* val4 = "nope";
  
    insert(A, key, value);
    insert(A, key2, val2);
    insert(A, key3, val3);
	insert(A, key4, val4);
    printf( "Inserted four keys to Dictionary\n");
	printDictionary(out, A);
    
	 delete( A, "morning" );
	 delete( A, "Have" );
	 delete( A, "depression" );
         delete( A, "sorry" );
	 printf("deleted everything in dictionary using delete()\n");
	 
	 insert(A, key, value);
	 makeEmpty(A);
	 printf("Making Dictionary Empty...\n");
	 printf("\n ADT ops tested\n");
	 freeDictionary(&A);
    fclose(out);
 
 return 0;
}
