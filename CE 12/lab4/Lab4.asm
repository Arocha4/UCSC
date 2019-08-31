;CMPE 12
;LAB 4
;Priscilla Usmani & Stephen Arredondo
;TuTh 6:00-8:00 Jay

;

;Being at memory x3000
	.ORIG x3000


START:
;Clear all Registers
	JSR CLRREGISTERS
	JSR GETINTEGER
	ST R4, INT1
	JSR CLRREGISTERS
	JSR GETINTEGER
	ST R4, INT2
	HALT

GETINTEGER
	ST R7, RET1
; Prints out greeting
	LEA	R0, GREETING
	PUTS

; Gets user-entered character (result in R0)
; echo it back  (otherwise not visible)
	GETC
	PUTC

; store string (otherwise it may be overwritten)
	ST	R0, USERINPUT1

;convert to decimal value
	JSR 	toDecimal
	ADD	R1, R0, #0
	JSR 	MUL10


; print out a newline and some other stuff
	LEA	R0, NEWLINE
	PUTS



; print out a greeting
	LEA	R0, GREETING
	PUTS

; get a user-entered character (result in R0)
; echo it back  (otherwise not visible)
	GETC
	PUTC

; store entered string (otherwise it may be overwritten)
	ST	R0, USERINPUT2

;convert to decimal	
	JSR 	toDecimal
	ADD	R2, R0, #0

; print out a newline 
	LEA	R0, NEWLINE
	PUTS
	
	ADD	R4, R2, R4
	LD	R7, RET1
	RET
	
CLRREGISTER	AND	R0, R0, 0
		AND	R1, R0, 0
		AND	R2, R0, 0
		AND	R3, R0, 0
		AND	R4, R0, 0
		AND 	R5, R5, 0
		AND	R6, R6, 0
		RET

toDecimal	ADD 	R0, R0, #-16
		ADD 	R0, R0, #-16
		ADD 	R0, R0, #-16
		RET

MUL10		ADD R3, R3, #9
		ADD R4, R1, #0
LOOP		ADD R4, R4, R1
		ADD R3, R3, #-1
		BRp	LOOP
		RET		

; strings
GREETING:	.STRINGZ	"enter a number: \n"
USERSTRING:	.STRINGZ	" = input \n"
NEWLINE:	.STRINGZ "\n";

; variables
USERINPUT1:	.FILL	0
USERINPUT2:	.FILL	0
INT1:		.FILL 	0
INT2:		.FILL	0
RET1:		.FILL	0
; end of code
	.END