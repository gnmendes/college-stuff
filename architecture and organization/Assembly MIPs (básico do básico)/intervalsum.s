.data
	msg1: .asciiz "\nExercicio 35: Receba 2 numeros inteiros, verifique qual o maior entre eles. Calcule e mostre o resultado da somatoria dos numeros impares entre esses valores."
	msg2: .asciiz "\nDigite um numero:"
	msg3: .asciiz "\nDigite outro numero:"
	msg4: .asciiz "\nA soma dos numeros impares entre esses numeros e:"
	msg5: .asciiz "\n"
.text
main:
	li $v0, 4
	la $a0, msg1
	syscall
	
	li $v0, 4
	la $a0, msg5
	syscall
	
	li $v0, 4
	la $a0, msg2
	syscall
	
	li $v0, 5
	syscall
	add $t0, $v0, $zero
	
	li $v0, 4
	la $a0, msg3
	syscall
	
	li $v0, 5
	syscall
	add $t1, $v0, $zero
	
	bgt $t0, $t1, if
	j else
	
	if:
	li $t2, 0
	while:
	add $t1, $t1,1
	rem $t3, $t1, 2
	bne $t3, 0, acumula
	j mataprog
	acumula:
	add $t2, $t2, $t1
	mataprog:
	bgt $t0, $t1, while
	j imprima
	
	else:
	li $t4, 0
	enquanto:
	add $t0, $t0, 1
	rem $t3, $t0, 2
	bne $t3, 0, acumulaai
	j end
	acumulaai:
	add $t4, $t4, $t0
	end:
	bgt $t1, $t0, enquanto
	j imprimadois
	
	imprima:
	li $v0, 4
	la $a0, msg4
	syscall
	
	li $v0, 1
	add $a0, $t2, $zero
	syscall
	j amem
	
	imprimadois:
	li $v0, 4
	la $a0, msg4
	syscall
	
	li $v0, 1
	add $a0, $t4, $zero
	syscall
	
	amem: