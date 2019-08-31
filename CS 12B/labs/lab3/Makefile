#Antoine Rocha
#arocha4@ucsc.edu
#cmps12b lab3
#MakeFile
#This is a Makefile for lab3 contains 


FLAGS= -std=c99 -Wall
SOURCES= FileReverse.c README Makefile
OBJECTS= FileReverse.o
EXEBIN= FileReverse
SUBMIT= submit cmps012b-pt.u17 lab3
CHECk= ls  /afs/cats.ucsc.edu/class/cmps012b-pt.u17/lab3/arocha4



all: $(EXEBIN)


$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)
$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)
clean :
	rm -f $(EXEBIN) $(OBJECTS)
submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)
      
check:	$(SOURCES)
	$(CHECK) $(SOURCES)
