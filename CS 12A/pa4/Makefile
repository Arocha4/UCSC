#Antoine Rocha
#arocha4
#makefile for pa5
#this is the make file for pa5 or Queens.java
Queens: Queens.class
	echo Main-class: Queens > Manifest
	jar cvfm Queens Manifest Queens.class
	rm Manifest
	chmod u+x Queens
Queens.class: Queens.java
	javac -Xlint Queens.java
clean:
	rm -f Queens.class Queens
submit: Makefile Queens.java
	submit cmps012a-pt.w17 pa5 Makefile Queens.java

