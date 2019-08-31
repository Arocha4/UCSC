/* Push a register*/
.macro  push reg
sw      \reg, ($sp)
addi    $sp, $sp, -4
.endm

/* Pop a register*/
.macro  pop reg
addi    $sp, $sp, 4
lw      \reg, ($sp)
.endm
	
#include <WProgram.h>

/* Jump to our customized routine by placing a jump at the vector 4 interrupt vector offset */
.section .vector_4,"xaw"
	j T1_ISR

/* The .global will export the symbols so that the subroutines are callable from main.cpp */
.global PlayNote
.global SetupPort
.global SetupTimer 

/* This starts the program code */
.text
/* We do not allow instruction reordering in our lab assignments. */
.set noreorder

	

/*********************************************************************
 * myprog()
 * This is where the PIC32 start-up code will jump to after initial
 * set-up.
 ********************************************************************/
.ent myprog

/* This should set up Port D pin 8 for digital output */
SetupPort:

	/* use knowledge gained from lab5 
	 * Virtual address: 0xBF88_ 
	 * TRISD: 0xBF88_60C0; 
	 * PORTD: 0xBF88_60D0; 
	 * LATD:  0xBF88_60E0; 
	 * ODCD:  0xBF88_60F0 
	 */
	 
	 li $t1, 8
	 la $t2, TRISDCLR
	 sw $t1, 0($t2)
	 
	 
	
	/* To test port D create a loop
	 * and toggle PORTD. Connect speaker to the correct pin
	 * and listen for sound.
	 */
	 
	jr 		$ra
	nop

/* This should configure Timer 1 and the corresponding interrupts,
 * but it should not enable the timer.
 */
SetupTimer:	
	/* Section 14 - 16-Bit Synchronous counter initialization steps */
	/* Lecture slide about interrupts */

	/* SETTING UP TIMER1 */
	/*******************************************************************************/
	/* T1CON = 0xBF80_0600
	 * TMR1 = 0xBF80_0610
	 * PR1 = 0xBF80_0620
	 * TCKPS = T1CON[5:4] = 0b11 to divide sysclk by 256
	 * TMR1 is current timer value (16 bits)
	 * PR1 is period value (16 bits)
	 */
	
	/* clear T1CON - put it in known state */
	la $t0, T1CON
	sw $0, 0($10)
	
	/* Set T1CKPS - set the prescaler */
	li $t1, 48
	la $t0, T1CONSET
	sw $t1, 0($t0)
	
	/* Clear TMR1 value - clear the counts if it was used */
	la $t0, TMR1
	sw $0, 0
	
	
	/* Set PR1 - set the period */
	li $t2, 156250   /* fclk/256 * 1/2 */	
	div $t2, $a0		/*divides 80,000,000 by the denominator (frequency in $a0). */
	mflo $t1
	sw $t1, PR1
	
	/* SETTING UP TIMER1 CORRESPONDING INTERRUPTS */
	/*******************************************************************************/
	/* IEC0 = oxBF88_1060
	 * IFS0 = 0xBF88_1030
	 * IPC1 = 0xBF88_10A0
	 * T1IE - timer1 interrupt enable (IEC04)
	 * T1IF - timer1 interrupt signal (IFSO4)
	 * T1IP<2:0> - timer 1 interrup priority (IPC1[4:2])
	 */
  
	/* Set T1IP - set the interrupt priority */
	li $t1, 0x10
	la $t0, IPC1
	sw $t1, 8($t0) 
	
	
	/* Clear T1IF - clear any prior interrupt */
	la $t0, IFS0
	li $t1, 0b10000
	sw $t1, 4($t0)
	
	/* Enable T1IE - enable the interrupts */
	li $t1, 0x16
	la $t0, IEC0
	sw $t1, 8($t0) 
	
	/* DO NOT TURN ON THE TIMER HERE (T1CON[15])(NOTE: Maybe later) */
	
	/* To test interrupt and T1_ISR, turn on timer here.
	 * Toggle port D in T1_ISR. Connect speaker in correct pin and
	 * listen for sound.
	 */
	push $ra
	pop $t1
	jr $ra
	nop

	
/* This should take the following arguments:
*  $a0 = tone frequency
*  $a1 = tone duration
*  $a2 = full note duration ($a2 - $a1 is the amount of silence after the tone)
*/
PlayNote:
	
	push $ra
	push $s0
	push $s1
	push $a0
	push $a1
	push $a2
	push $t0
	push $t1
	push $t2

/*Sets tone frequency and gets the period, Checks for zero input using BEQ*/
	move $t0, $a0
	BEQ $t0, $0, SKIPNOTE
	nop
/*set period
	li 		$t3, 0xBF800620
	sw 		$t1, 8($t3)
/*enables the timer*/
	li $t0, 0xBF800600
	li $t1, 0b1000000000000000
	sw $t1, 8($t0)
/*delays for the tone duration*/
	move $a0, $a1
	jal delay
	nop
/*disables the timer*/
	li $t0, 0xBF800600
	li $t1, 0b1000000000000000
	sw $t1, 4($t0)
/*calculates the silence AFTER the tone, note: full note minus tone duration*/
	sub $a0, $a2, $a1
	jal delay
	nop
/*puts registers back in order for return*/
	pop $t2
	pop $t1
	pop $t0
	pop $a2
	pop $a1
	pop $a0
	pop $s1
	pop $s0
	pop $ra
	jr $ra
	nop
	
/*Here's the branch just in case there's zero frequency, delay for 500 miliseconds*/
SKIPNOTE:
	li $a0, 500
	jal delay
	nop
	pop $t2
	pop $t1
	pop $t0
	pop $a2
	pop $a1
	pop $a0
	pop $s1
	pop $s0
	pop $ra
	jr $ra
	nop

	
/* This procedure is not required, but I found it easier this way. It is not called from main.cpp. */
/* This turns on the timer to start counting */	
EnableTimer:
	jr $ra
	nop
	
/* This procedure is not required, but I found it easier this way. It is not called from main.cpp. */
/* This turns off the timer from counting */
DisableTimer:
	jr $ra
	nop
	
	
/* The ISR should toggle the speaker output value and then clear and re-enable the interrupts. */
T1_ISR:
	/* Your program will go to ISR everytime an interrupt occurs, no matter which part you are in your program */
	/* So be carefull because it may overwrite your registers. So, OBEY REGISTER CALLING CONVENTIONS!!! */
	/* Save including t0-t9 */
	/* push */
	
	/* ISR body here */
	push $t0
	push $t1
	push $t2
	push $t3
	push $t4
	push $t5
	push $t6
	push $t7
	push $t8
	push $t9
	push $a0
	push $a1
	push $a2
	push $v0
	push $v1
	
	
	la $t2, PORTD 
	li $t1, 8
	sw $t1, 12($t2 )
	
	
	
	
	/* Clear T1IF - clear any prior interrupt */
	la $t0, IFS0
	li $t1, 0b10000
	sw $t1, 4($t0)
	
	/* pop registers */
	
	la $t0, TMR1
	sw $zero, 0($t0)
	
	pop $v1
	pop $v0
	pop $a2
	pop $a1
	pop $a0
	pop $t9
	pop $t8
	pop $t7
	pop $t6
	pop $t5
	pop $t4
	pop $t3
	pop $t2
	pop $t1
	pop $t0
	
	/* ERET is return instruction */
	eret
	
	

.end myprog /* directive that marks end of 'myprog' function and registers
           * size in ELF output
           */
