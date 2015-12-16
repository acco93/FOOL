push 0
push 11
push 11
push -3
lfp
add
lw
push -2
lfp
add
lw
bless label2
push -2
lfp
add
lw
push -3
lfp
add
lw
beq label2
push 0
b label3
label2:  
push 1 
label3:
push 1
beq label0
push 0
b label1
label0: 
push 1
label1:
print
halt
