# a simple makefile fo rhe GCD program
World: GCD.class
echo Main-class: GCD > Manifest
	jar cvfm GCD Manifest GCD.class
	rm Manifest
	chmod u+x GCD
GCD.class: GCD.java
	javac -Xlint GCD.java
clean:
	rm –f GCD.class GCD
submit: Makefile GCD.java
	submit cmps012a-pt.w17 lab4 Makefile GCD.java
