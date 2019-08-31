# A simple make file for the GCD program
Roots: Roots.class
	echo Main-class: Roots > Manifest
	jar cvfm Roots Manifest Roots.class
	rm Manifest
	chmod u+x Roots
Roots.class: Roots.java
	javac -Xlint Roots.java
clean:
	rm –f Roots.class Roots
submit: Makefile Roots.java
	submit cmps012a-pt.w17 pa4 Makefile Roots.java
