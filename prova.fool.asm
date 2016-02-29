# return address fittizio 
push 0

# code generation FUN NODE f
lfp
push function0

debug
# CALL NODE di f
# Control link
lfp
# parametri (1)
push 2
# setto l'AL
push -2
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
js
# ============= 
nodebug
halt

function0:
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
push 0
beq label2
push 0
b label3
label2:  
push 1 
label3:
push 1
beq label0
# CALL NODE di f
# Control link
lfp
# parametri (1)
# ID x
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
push 1
sub
# setto l'AL
push -2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -3
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
b label1
label0: 
push 0
label1:
srv
sra
pop
pop
sfp
lrv
lra
js
