.data
msg_0:
	.word 61
	.ascii "ArrayIndexOutOfBoundsError: negative index/index too large.
 "
msg_1:
	.word 6
	.ascii "%.*s\0"

.text

.global main
main:
	PUSH  {lr}
	POP   {pc}
	.ltorg
lib_check_array_bounds:
	PUSH  {lr}
	CMP   r0, #0
	LDRLT r0, =msg_0
	BLLT  lib_throw_runtime_error
	LDR   r1, [r1]
	CMP   r0, r1
	LDRCS r0, =msg_0
	BLCS  lib_throw_runtime_error
	POP   {pc}
lib_throw_runtime_error:
	BL    lib_print_string
	MOV   r0, #-1
	BL    exit
lib_print_string:
	PUSH  {lr}
	LDR   r1, [r0]
	ADD   r2, r0, #4
	LDR   r0, =msg_1
	ADD   r0, r0, #4
	BL    printf
	MOV   r0, #0
	BL    fflush
	POP   {pc}
