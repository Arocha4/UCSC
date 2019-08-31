#Antoine Rocha
#arocha4@ucsc.edu
#cmps12b lab4
#MakeFile
#This is a Makefile for lab4 


FLAGS= -std=c99 -Wall
SOURCES= charType.c 
OBJECTS= charType.o
EXEBIN= charType
SUBMIT= submit cmps012b-pt.u17 lab4
VFLAGS = --leak-check=full
OUTTEST= charTypeOut

all: $(EXEBIN)


$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)
$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)
clean :
	rm -f $(EXEBIN) $(OBJECTS) $(OUTTEST)
submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)
      
check:
	valgrind $(VFLAGS) ./$(EXEBIN) $(SOURCES) $(OUTTEST)
