# Antoine Rocha
# arocha4
# lab8 MAkefile
# this is the Makefile for lab8
GCD: GCD.o
	gcc -o GCD GCD.o

GCD.o: GCD.c
	gcc -c -std=c99 GCD.c

clean:
	rm -f GCD.o

spotless:
	rm -f GCD.o GCD

submit: Makefile GCD.c
	submit cmps012a-pt.w17 lab8 Makefile GCD.c
