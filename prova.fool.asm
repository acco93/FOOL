push 0
push function0
push function1
push 1
push 1
beq label0
push 0
b label1
label0: 
push 1
label1:
print
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
lfp
push 2
lfp
add
lw
push 1
lfp
add
lw
lfp
push 3
lfp
add
lw
js
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js
