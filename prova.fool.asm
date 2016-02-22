# return address fittizio 
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
# parametri (4)
# ID y
# ID normale (non funzionale) recupero il valore
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
# ID x
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 0 volte
add
lw
# ID l
# ID funzionale
# recupero il valore del FP
push -8
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push -9
lfp
# risalgo la catena statica 0 volte
add
lw
# ID a
# ID funzionale
# recupero il valore del FP
push -4
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push -5
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -6
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push -7
lfp
# risalgo la catena statica 0 volte
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
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
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
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# code generation FUN NODE b
lfp
push function1
# ============= 
# Body della funzione
# ID x
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# CALL NODE di b
# Control link
lfp
# parametri (1)
push 1
# setto l'AL
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push -4
lfp
# risalgo la catena statica 0 volte
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
# parametri (2)
# ID x
# ID normale (non funzionale) recupero il valore
push 5
lfp
# risalgo la catena statica 0 volte
add
lw
# ID y
# ID normale (non funzionale) recupero il valore
push 6
lfp
# risalgo la catena statica 0 volte
add
lw
add
# CALL NODE di f1
# Control link
lfp
# parametri (0)
# setto l'AL
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
js
# ============= 
# setto l'AL
push 4
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push 3
lfp
# risalgo la catena statica 0 volte
add
lw
js
# ============= 
bless label2
# CALL NODE di f2
# Control link
lfp
# parametri (2)
# ID x
# ID normale (non funzionale) recupero il valore
push 5
lfp
# risalgo la catena statica 0 volte
add
lw
# ID y
# ID normale (non funzionale) recupero il valore
push 6
lfp
# risalgo la catena statica 0 volte
add
lw
add
# CALL NODE di f1
# Control link
lfp
# parametri (0)
# setto l'AL
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
js
# ============= 
# setto l'AL
push 4
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push 3
lfp
# risalgo la catena statica 0 volte
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
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
# ID y
# ID normale (non funzionale) recupero il valore
push 2
lfp
# risalgo la catena statica 0 volte
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
