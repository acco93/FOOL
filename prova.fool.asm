push 0

push 3
push 0
# code generation FUN NODE a
lfp
push function0
# ============= 
# code generation FUN NODE g
lfp
push function2
# ============= 
# code generation FUN NODE l
lfp
push function3
# ============= 

# CALL NODE di g
# Control link
lfp
# Parametri
# ID y
push -3
lfp
add
lw
# ID x
push -2
lfp
add
lw
# ID l
push -8
lfp
add
lw
push -9
lfp
add
lw
# ID a
push -4
lfp
add
lw
push -5
lfp
add
lw
# setto l'AL
push -6
lfp
add
lw
# setto l'indirizzo a cui saltare
push -7
lfp
add
lw
js
# ============= 
print
halt

function1:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# ID x
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js

function0:
cfp
lra
# Dichiarazioni della funzione 
# ID x
push -2
lfp
lw
add
lw
# code generation FUN NODE b
lfp
push function1
# ============= 
# Body della funzione
# ID x
push -2
lfp
lw
add
lw
# CALL NODE di b
# Control link
lfp
# Parametri
push 1
# setto l'AL
push -3
lfp
add
lw
# setto l'indirizzo a cui saltare
push -4
lfp
add
lw
js
# ============= 
add
srv
pop
pop
pop
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
push 10
# CALL NODE di f2
# Control link
lfp
# Parametri
# ID x
push 5
lfp
add
lw
# ID y
push 6
lfp
add
lw
add
# CALL NODE di f1
# Control link
lfp
# Parametri
# setto l'AL
push 2
lfp
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
add
lw
js
# ============= 
# setto l'AL
push 4
lfp
add
lw
# setto l'indirizzo a cui saltare
push 3
lfp
add
lw
js
# ============= 
bless label2
# CALL NODE di f2
# Control link
lfp
# Parametri
# ID x
push 5
lfp
add
lw
# ID y
push 6
lfp
add
lw
add
# CALL NODE di f1
# Control link
lfp
# Parametri
# setto l'AL
push 2
lfp
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
add
lw
js
# ============= 
# setto l'AL
push 4
lfp
add
lw
# setto l'indirizzo a cui saltare
push 3
lfp
add
lw
js
# ============= 
push 10
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
srv
sra
pop
pop
pop
pop
pop
pop
pop
sfp
lrv
lra
js

function3:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# ID x
push 1
lfp
add
lw
# ID y
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
