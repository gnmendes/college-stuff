.data
	msg1: .asciiz "\nInsira um numero:"
	msg2: .asciiz "\n"
.text
main:
	li $v0, 4
	la $a0, msg1
	syscall
	li $v0, 5
	syscall
	add $t0, $v0, $zero
	#t0=n
	
	#contadora 1= $t1 atual
	#contadora 2= $t2 anterior
	li $t1, 1
	li $t2, -1
	li $t6, 1
	#laçozinho para ficar rodando até o termo que o usuário inseriu
	while:
	#t3 aux
	add $t3, $t1, $t2
	#print
	li $v0, 4
	la $a0, msg2
	syscall
	li $v0, 1
	add $a0, $t3, $zero
	syscall
	#aux
	add $t4, $t3, $zero
	#atual
	add $t5, $t1, $zero
	#anterior recebendo atual
	add $t2, $t5, $zero
	#atual recebendo aux
	add $t1, $t4, $zero
	
	#contadora de merda para acrescer
	add $t6, $t6, 1
	bge $t0, $t6, while
	#maior ou igual pelo simples fato de que se eu jogo apenas um maior, ele faz um termo a menos