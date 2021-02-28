.data
	msg1: .asciiz "\nDigite um numero equivalente a um ano:"
	msg2: .asciiz "\nDigite outro numero equivalente a um ano:"
	msg3: .asciiz "\nIntervalo maior que 1000 anos nao e valido!"
	msg4: .asciiz "\n"
	msg5: .asciiz "\nQuestao 18:Faca um algoritmo que leia dois valores correspondentes a anos e mostre quais os anos nao bissextos existem entre eles. (A diferenca entre os anos nao pode ser maior que 1000)"
.text
main:
	li $v0, 4
	la $a0, msg5
	syscall
	
	li $v0, 4
	la $a0, msg4
	syscall
	
	li $v0, 4
	la $a0, msg1
	syscall
	
	li $v0, 5
	syscall
	add $t0, $v0, $zero
	
	li $v0, 4
	la $a0, msg2
	syscall
	
	li $v0, 5
	syscall
	add $t1, $v0, $zero

	bgt $t0, $t1, se
	j senao

	se:
	sub $t2, $t0, $t1
	j fimse
	senao:
	sub $t2, $t1, $t0
	fimse:
	
	bgt $t2, 1000, if
	j else
	if:
	li $v0, 4
	la $a0, msg3
	syscall
	j endwhile
	
	else:
	bgt $t0, $t1, see
	j senaoo

	see:
	while:
	add $t1, $t1, 1
	rem $t4, $t1, 400
	beq $t4, 0, slabel

	blabel:
	rem $t5, $t1, 4
	beq $t5, 0, dlabel
	j label
	
	dlabel:
	rem $t5, $t1, 100
	bne $t5, 0, slabel

	label:
	li $v0, 4
	la $a0, msg4
	syscall	
	li $v0, 1
	add $a0, $t1, $zero
	syscall
	
	slabel:
	blt $t1, $t0, while
	j endwhile

	senaoo:
	enquanto:
	add $t0, $t0, 1
	rem $t4, $t0, 400
	beq $t4, 0, simprima
	
	rem $t5, $t0, 4
	beq $t5, 0, senaob	
	j imprima
	senaob:
	rem $t5, $t0, 100
	bne $t5, 0, simprima
	
	imprima:
	li $v0, 4
	la $a0, msg4
	syscall
	li $v0, 1
	add $a0, $t0, $zero
	syscall

	simprima:	
	blt $t0, $t1, enquanto
	endwhile:
