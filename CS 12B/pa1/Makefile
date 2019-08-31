#Antoine Rocha
#arocha4@ucsc.edu
#1479979
#cmps12b lab1
#Makefile
#A Makefile to submit the files for pa1
#------------------------------------------------------------------------------
JAVASRC 	= Recursion.java 
SOURCES 	= README Makefile $(JAVASRC)
MAINCLASS 	= Recursion
CLASSES		= Recursion.class 
JARFILE 	= Recursion
SUBMIT 		= submit cmps012b-pt.u17 pa1
CHECK           = ls  /afs/cats.ucsc.edu/class/cmps012b-pt.u17/pa1/arocha4

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)
$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)
clean:
	rm $(CLASSES) $(JARFILE)
submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)
check: $(SOURCES)
	$(CHECK) $(SOURCES)
