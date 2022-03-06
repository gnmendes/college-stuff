.data
	msg1: .asciiz "\nInsira um numero:"
	ln:   .asciiz "\n"
.text
main:

	li $v0, 4
	la $a0, msg1
	syscall
	li $v0, 5
	syscall
	add $t0, $v0, $zero
	
	#bin
	li $t1, 0
	#iterador
	li $t2, 1
	
	
	while:
	# resto
	rem $t3, $t0, 2
	#divisao
	div $t0, $t0, 2
	
	mul $t4, $t2, $t3
	#soma
	add $t1, $t1, $t4
	mul $t2, $t2, 10
	
	bgt $t0, 0, while
	
	li $v0, 4
	la $a0, ln
	syscall
	
	li $v0, 1
	add $a0, $t1, $zero
	syscall