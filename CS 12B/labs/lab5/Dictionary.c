// Antoine Rocha
// arocha4
// cmps12M
// lab5
// Dictionary.c 
// functions for DictionaryClient

#include<stdlib.h>
#include<assert.h>
#include<stdio.h>
#include<string.h>
#include"Dictionary.h"

// NodeObj
typedef struct NodeObject{
    char* key;
    char* value;
    struct NodeObject* next;
} 
NodeObject;

// Node
 typedef NodeObject* Node;


 
 // newNode()
Node newNode(char* k, char* v) {
    Node H = malloc(sizeof(NodeObject));
    assert(H!=NULL);
    H->key = k;
    H->value = v;
    H->next = NULL;
    return(H);
}


// freeNode()
void freeNode(Node* pNode){
    if( pNode!=NULL && *pNode!=NULL ){
        free(*pNode);
        *pNode = NULL;
    }
}



// DictionaryObject
typedef struct DictionaryObj{
    Node Base;
    int numItem;
} DictionaryObj;



// findKey()
Node findKey(Dictionary STR, char* k){
    for(Node H = STR->Base; H!=NULL; H = H->next){
        if(strcmp(H->key, k) == 0){
            return H;
        }
    }
    return NULL;
}



// deleteAll()
 deleteAll(Node H){
    if( H!=NULL ){
        deleteAll(H->next);
        freeNode(&H);
    }
}

// newDictionary()
Dictionary newDictionary(){
    Dictionary DI = malloc(sizeof(DictionaryObj));
    assert(DI!=NULL);
    DI->Base = NULL;
    DI->numItem = 0;
    return DI;
}

// freeDictionary()
void freeDictionary(Dictionary* p){
   	if( p != NULL && *p != NULL){
		if( !isEmpty(*p) )
			makeEmpty(*p);
		free(*p);
		*p = NULL;
    }
}





// size()
int size(Dictionary DI){
    if( DI==NULL ){
        fprintf(stderr,
         "size() Dictionary is NULL\n");
        exit(EXIT_FAILURE);
    }
    return(DI->numItem);
}




// isEmpty()
int isEmpty(Dictionary DI){
    if( DI==NULL ){
        fprintf(stderr,
         "Error: isEmpty() NULL Dictionary\n");
        exit(EXIT_FAILURE);
    }
    return(DI->numItem==0);
}

// lookup()
char* lookup(Dictionary DI, char* k){
   
    Node H;
    if( DI==NULL ){
        fprintf(stderr,
         "Error:lookup() NULL Dictionary\n");
        exit(EXIT_FAILURE);
    }
    H = findKey(DI, k);
    return ( H==NULL ? NULL : H->value );
}















// delete()
void delete(Dictionary  DI, char* k){
    Node H = findKey(DI, k);
    if( DI==NULL ){
        fprintf(stderr,
         "Error: calling delete():NULL Dictionary\n");
        exit(EXIT_FAILURE);
    }
   
   if( H==NULL ){
        fprintf(stderr,
         "Error: delete() no key: \"%s\"\n", k);
        exit(EXIT_FAILURE);
    }
   
   if(lookup(DI, k) != NULL){

		   if(H == DI->Base){
            DI->Base = DI->Base->next;
            H->next = NULL;
         
		 } else {
            Node STR = DI->Base;
            
			while(STR->next != H){
               STR = STR->next;
            }
            STR->next = H->next;
         }
      }
    DI->numItem--;
}


// insert()    
void insert(Dictionary DI, char* k, char* v){
    
	Node H, A, B;
   
   if( DI==NULL ){
        fprintf(stderr,
         "Dictionary Error: calling insert() on NULL Dictionary reference\n");
        exit(EXIT_FAILURE);
    }
    
	if( findKey(DI, k)!=NULL ){
        fprintf(stderr, "Error: cannot insert() duplicate key: \"%s\"\n", k);
        exit(EXIT_FAILURE);
    }
   
   if(lookup(DI,k)==NULL){
        H = newNode(k, v);
        B = NULL;
        A = DI->Base;
       
	   while(A!=NULL){
            B = A;
            if( strcmp(k, A->key)<0 ){
                A = A->next;
            }
            else{
                A = A->next;
            }
        }
        if(B==NULL){
            DI->Base = H;
        }
        else if(strcmp(k, B->key) < 0){
            B->next = H;
        }
        else{
            B->next = H;
        }
        DI->numItem++;
    }    
} 




// printDictionary()
void printDictionary(FILE* out, Dictionary DI){
    
	if( DI==NULL ){
        fprintf(stderr,
         " Error: printDictionary() on NULL"
         " Dictionary reference\n");
        exit(EXIT_FAILURE);
    }
    
	for(Node H = DI->Base; H!=NULL; H = H->next){
        fprintf(out, "%s %s\n", H->key, H->value);
    }
}


// makeEmpty()
void makeEmpty(Dictionary DI){
    deleteAll(DI->Base);
    DI->Base = NULL;
    DI->numItem= 0;
}
