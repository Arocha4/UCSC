#Antoine Rocha
#arocha4@ucsc.edu
#1479979
#cmps12M lab1
#6/29/2017
#Makefile
#A Makefile to submit the files for lab1
#------------------------------------------------------------------------------
JAVASRC 	= HelloUser.java HelloUser2.java
SOURCES 	= README Makefile $(JAVASRC)
MAINCLASS 	= HelloUser2
CLASSES		= HelloUser.class HelloUser2.class
JARFILE 	= Hello
SUBMIT 		= submit cmps012b-pt.u17 lab1
CHECK           = ls  /afs/cats.ucsc.edu/class/cmps012b-pt.u17/lab1/arocha4

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
