#Antoine Rocha
#arocha4
#cmps12M lab5
#Makefile for lab5 checks for memory leaks as well




ADT  = Dictionary
SOURCES   = $(ADT).c $(ADT)Client.c $(ADT)Test.c
OBJECTS   = $(ADT).o $(ADT)Client.o 
HEADERS   = $(ADT).h
EXEBIN    = $(ADT)Client 
FLAGS     = -std=c99 -Wall


all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

DictionaryTest : DictionaryTest.o
	gcc -o DictionaryTest DictionaryTest.o Dictionary.o

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS) DictionaryTest.o DictionaryTest

check:
	valgrind --leak-check=full $(EXEBIN)
