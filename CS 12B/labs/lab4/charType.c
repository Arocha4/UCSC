/* Antoine Rocha
* arocha4 
* cmps12m 
*lab4
* chartype.c
* this program categorizes elements in a string
*/



#define maxlength 1000
#include<stdio.h> 
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>
#include<string.h>



int main(int argc, char* argv[]){
	
	FILE* in;
	FILE* out;
	
	char* line;
	char* alphabet;
	char* digits;
	char* punctual;
	char* whitespace;

	//3 arguments in commandline
	if( argc!=3){
		
		printf("Usage: %s input-file output-file", argv[0]); // usage statement 
		
		exit(EXIT_FAILURE);
	}

	// set to inputfile.
	
	if( (in=fopen(argv[1], "r"))==NULL ){
		
		printf("Unable to read from file %s", argv[1]); //err message
		
		exit(EXIT_FAILURE);
	}

	//set to outputfile.
	
	if( (out=fopen(argv[2], "w"))==NULL ){
		
		printf("Unable to read from file %s", argv[2]); //err message
		
		exit(EXIT_FAILURE);
	}

	line = calloc(maxlength+1, sizeof(char));
	alphabet = calloc(maxlength+1, sizeof(char));
	digits = calloc(maxlength+1, sizeof(char));
	punctual = calloc(maxlength+1, sizeof(char));
	whitespace = calloc(maxlength+1, sizeof(char));
	assert( line!=NULL && alphabet!=NULL && digits!=NULL && punctual!=NULL && whitespace!=NULL);
    
	int linenumber=0;
	while( fgets(line, maxlength, in) != NULL ){
	
	extract_chars(line, alphabet, digits, punctual, whitespace); // assign to string 
        int alphabetlen = (int) strlen(alphabet);    // varibles to hold stringlen
		int digitslen = (int) strlen(digits);
		int punctuallen = (int) strlen(punctual);
		int whitespacelen = (int) strlen(whitespace);		
		linenumber++;
         
		 
		 // text output
		fprintf(out, "%s %d %s\n", "line ", linenumber, "contains:");
		fprintf(out, "%d %s %s\n", alphabetlen, (alphabetlen==1 ? "alphabetic character:": "alphabetic characters:") , alphabet);
		fprintf(out, "%d %s %s\n", digitslen, (digitslen==1 ? "numeric character:" : "numeric characters:"), digits);
		fprintf(out, "%d %s %s\n", punctuallen, (punctuallen==1 ? "punctuation character:" : "punctuation characters:"), punctual);
		fprintf(out, "%d %s %s\n", whitespacelen, (whitespacelen==1 ? "whitespace character:" : "whitespace characters:"), whitespace);

	}
    free(line);
	free(alphabet);
	free(digits);
	free(punctual);
	free(whitespace);
    fclose(in);
	fclose(out);
}


void extract_chars(char* s, char* a, char* d, char* p, char* w){ 
	//f,e,h,g holds the index for each array
	int e=0; 
	int f=0;
	int g=0;
	int h=0;
	int i=0;
	
	while(s[i] != '\0' && i<maxlength){
	
	if( isalpha(s[i]) ) // if alphabetic set to s[i] same for rest
			a[f++] = s[i];

		else if( isdigit(s[i]) )
			
		    d[e++] = s[i];

		else if( ispunct(s[i]) )
			
		    p[h++] = s[i];

		else
			
		     w[g++] = s[i];
		      
			  i++;
 }


	a[f] = '\0';
	d[e] = '\0';
	p[h] = '\0';
	w[g] = '\0';
}
