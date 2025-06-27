.model small
.stack 100h
.data
student_number db '123456789'
student_sum dw 24
input_buffer db 3 dup (?)
total_sum dw 0

.code
start:
    mov dx, 0FFh
    mov al, 0C3h
    out dx, al
    mov al, 37h
    out dx, al

main_loop:
    mov cx, 3
    lea di, input_buffer
read_data:
    call read_char
    mov [di], al
    inc di
    loop read_data

    xor ax, ax
    lea si, input_buffer
    mov cx, 3
calculate_sum:
    mov al, [si]
    sub al, '0'
    cmp al, 9
    jbe valid_digit
    mov al, 10
valid_digit:
    add ax, [total_sum]
    mov [total_sum], ax
    inc si
    loop calculate_sum

    mov ax, [total_sum]
    cmp ax, student_sum
    ja  turn_on_two_leds
    jmp turn_on_one_led

turn_on_two_leds:
    mov dx, 0F0h
    mov al, 0C3h
    out dx, al
    jmp reset_sum

turn_on_one_led:
    mov dx, 0F0h
    mov al, 01h
    out dx, al
    jmp reset_sum

reset_sum:
    xor ax, ax
    mov [total_sum], ax
    jmp main_loop

nmi_handler:
    mov dx, 0F0h
    mov al, 0FFh
    out dx, al

wait_for_reset:
    hlt
    jmp wait_for_reset

read_char proc
    mov dx, 0FEh
wait_char:
    in al, dx
    test al, 80h
    jz wait_char
    ret
read_char endp

end start
