# return address fittizio 
push 0

# code generation FUN NODE f
lfp
push function4
# ============= 
# code generation FUN NODE r
lfp
push function5
# ============= 
# code generation FUN NODE make
lfp
push function6
# ============= 
push -1

# CALL NODE di f
# Control link
lfp
# parametri (2)
# ID r
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
# CALL NODE di make
# Control link
lfp
# parametri (1)
# ID x
# ID normale (non funzionale) recupero il valore
push -8
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
print
halt

function0:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
# ID x
# ID normale (non funzionale) recupero il valore
push -1
lfp
# risalgo la catena statica 1 volte
lw
add
lw
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
# ID y
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
# ID x
# ID normale (non funzionale) recupero il valore
push -1
lfp
# risalgo la catena statica 1 volte
lw
add
lw
push 1
add
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
# ID y
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
push 1
add
srv
sra
pop
sfp
lrv
lra
js

function4:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# CALL NODE di rel
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
# setto l'AL
push 3
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
js
# ============= 
push 1
beq label0
#setto il CL
lfp
# setto l'AL
push 1
lfp
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
add
lw
push 1
add
lw
js
b label1
label0: 
#setto il CL
lfp
# setto l'AL
push 1
lfp
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
add
lw
push 0
add
lw
js
label1:
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

function5:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
#setto il CL
lfp
# setto l'AL
push 1
lfp
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
add
lw
push 0
add
lw
js
#setto il CL
lfp
# setto l'AL
push 1
lfp
add
lw
# setto l'indirizzo a cui saltare
push 1
lfp
add
lw
push 1
add
lw
js
beq label4
push 0
b label5
label4:  
push 1 
label5:
push 1
beq label2
push 0
b label3
label2: 
push 1
label3:
srv
sra
pop
pop
sfp
lrv
lra
js

function6:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# ID a
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
push -1
beq label8
push 0
b label9
label8:  
push 1 
label9:
push 1
beq label6
# ID a
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
b label7
label6: 
# pusho il 0 parametro della new sullo stack
push 1
# pusho il 1 parametro della new sullo stack
push 1
# salvo il campo 0 nell'heap
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# salvo il campo 1 nell'heap
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto hp sullo stack (object pointer)
lhp
# metto l'indirizzo del 0 metodo nell'heap 
push function2 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function3 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
label7:
srv
sra
pop
pop
sfp
lrv
lra
js
