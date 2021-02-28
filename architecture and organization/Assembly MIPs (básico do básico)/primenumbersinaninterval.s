.data
	queereye: .asciiz "\nO intuito do programa e mostrar todos os numeros NAO primos em um intervalo."
	pose: .asciiz "\nEntao, vamos la!"
	westworld:.asciiz"\nDigite um numero:"
	thehandmaidstale:.asciiz"\nDigite outro numero:"
	callmebyyourname: .asciiz "\nNao ha intervalo entre numeros iguais!"
	vikingsoverrated:.asciiz"\n"
.text
main:
	li $v0, 4
	la $a0, queereye
	syscall
	
	li $v0, 4
	la $a0, pose
	syscall
	
	li $v0, 4
	la $a0, vikingsoverrated
	syscall
	li $v0, 4
	la $a0, westworld
	syscall
	li $v0, 5
	syscall
	add $t1, $v0, $zero
	li $v0, 4
	la $a0, vikingsoverrated
	syscall
	
	li $v0, 4
	la $a0, thehandmaidstale
	syscall
	li $v0, 5
	syscall
	add $t0, $v0, $zero	
	bgt $t0, $t1, if
	beq $t0, $t1, melodrama
	j else
	if:
	add $t2, $t0, $zero
	add $t0, $t1, $zero
	add $t1, $t2, $zero
		
	else:
	
	firstwhile:
		add $t0, $t0, 1
		li $t5, 1
		li $t9, 0
			secondwhile:
				add $t5, $t5, 1
				rem $t6, $t0, $t5
				beq $t6, 0, obssessed
				j end
		
				obssessed:
				add $t9, $t9, 1
				end:
			blt $t5, $t0, secondwhile
				
				beq $t9, 1, endfirstloop
			
		li $v0, 4
		la $a0, vikingsoverrated
		syscall
		li $v0, 1
		add $a0, $t0, $zero
		syscall
		
		endfirstloop:
	bgt $t1, $t0, firstwhile
	j consideration
	
		melodrama:
		li $v0, 4
		la $a0, callmebyyourname
		syscall
	
	consideration: