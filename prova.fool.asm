# return address fittizio 
push 0

# code generation FUN NODE printList
lfp
push function2
# ============= 
# code generation FUN NODE append
lfp
push function5
# ============= 
# code generation FUN NODE filter
lfp
push function6
# ============= 
# code generation FUN NODE quicksort
lfp
push function7
# ============= 
# code generation FUN NODE increasing
lfp
push function10
# ============= 
# code generation FUN NODE decreasing
lfp
push function12
# ============= 
# pusho il 0 parametro della new sullo stack
push 3
# pusho il 1 parametro della new sullo stack
# pusho il 0 parametro della new sullo stack
push 4
# pusho il 1 parametro della new sullo stack
# pusho il 0 parametro della new sullo stack
push 6
# pusho il 1 parametro della new sullo stack
# pusho il 0 parametro della new sullo stack
push 1
# pusho il 1 parametro della new sullo stack
# pusho il 0 parametro della new sullo stack
push 2
# pusho il 1 parametro della new sullo stack
# pusho il 0 parametro della new sullo stack
push 5
# pusho il 1 parametro della new sullo stack
push -1
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp

# CALL NODE di printList
# Control link
lfp
# parametri (1)
# CALL NODE di decreasing
# Control link
lfp
# parametri (1)
# ID l
# ID normale (non funzionale) recupero il valore
push -14
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -12
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push -13
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
halt

function0:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
# ID f
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
# ID r
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

function3:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# pusho il 0 parametro della new sullo stack
# ID i
# ID normale (non funzionale) recupero il valore
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
# pusho il 1 parametro della new sullo stack
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
srv
sra
pop
pop
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
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
push -1
beq label2
push 0
b label3
label2:  
push 1 
label3:
push 1
beq label0
# CALL NODE di makeList
# Control link
lfp
# parametri (2)
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
print
# CALL NODE di printL
# Control link
lfp
# parametri (1)
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
# setto l'AL
push -4
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -5
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
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
push -1
label1:
srv
sra
pop
pop
sfp
lrv
lra
js

function2:
cfp
lra
# Dichiarazioni della funzione 
# code generation FUN NODE makeList
lfp
push function3
# ============= 
# code generation FUN NODE printL
lfp
push function4
# ============= 
# Body della funzione
# CALL NODE di printL
# Control link
lfp
# parametri (1)
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -4
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'indirizzo a cui saltare
push -5
lfp
# risalgo la catena statica 0 volte
add
lw
js
# ============= 
srv
pop
pop
pop
pop
sra
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
# ID l1
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
push -1
beq label6
push 0
b label7
label6:  
push 1 
label7:
push 1
beq label4
# pusho il 0 parametro della new sullo stack
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
# pusho il 1 parametro della new sullo stack
# CALL NODE di append
# Control link
lfp
# parametri (2)
# ID l2
# ID normale (non funzionale) recupero il valore
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
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
# setto l'AL
push -4
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -5
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
b label5
label4: 
# ID l2
# ID normale (non funzionale) recupero il valore
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
label5:
srv
sra
pop
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
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
push -1
beq label10
push 0
b label11
label10:  
push 1 
label11:
push 1
beq label8
# CALL NODE di check
# Control link
lfp
# parametri (1)
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
beq label12
# CALL NODE di filter
# Control link
lfp
# parametri (2)
# ID check
# ID funzionale
# recupero il valore del FP
push 3
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
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
# setto l'AL
push -6
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -7
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
b label13
label12: 
# pusho il 0 parametro della new sullo stack
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
# pusho il 1 parametro della new sullo stack
# CALL NODE di filter
# Control link
lfp
# parametri (2)
# ID check
# ID funzionale
# recupero il valore del FP
push 3
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
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
# setto l'AL
push -6
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -7
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
label13:
b label9
label8: 
push -1
label9:
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

function8:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# CALL NODE di rel
# Control link
lfp
# parametri (2)
# ID pivot
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
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
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push 2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
srv
sra
pop
pop
sfp
lrv
lra
js

function9:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# CALL NODE di rel
# Control link
lfp
# parametri (2)
# ID x
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
# ID pivot
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'AL
push 3
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push 2
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
srv
sra
pop
pop
sfp
lrv
lra
js

function7:
cfp
lra
# Dichiarazioni della funzione 
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
push -1
beq label16
push 0
b label17
label16:  
push 1 
label17:
push 1
beq label14
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
b label15
label14: 
push 0
label15:
# code generation FUN NODE prec
lfp
push function8
# ============= 
# code generation FUN NODE succ
lfp
push function9
# ============= 
# Body della funzione
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
push -1
beq label20
push 0
b label21
label20:  
push 1 
label21:
push 1
beq label18
# CALL NODE di append
# Control link
lfp
# parametri (2)
# pusho il 0 parametro della new sullo stack
# ID pivot
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 0 volte
add
lw
# pusho il 1 parametro della new sullo stack
# CALL NODE di quicksort
# Control link
lfp
# parametri (2)
# ID rel
# ID funzionale
# recupero il valore del FP
push 3
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
# CALL NODE di filter
# Control link
lfp
# parametri (2)
# ID succ
# ID funzionale
# recupero il valore del FP
push -5
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push -6
lfp
# risalgo la catena statica 0 volte
add
lw
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -6
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -7
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
# setto l'AL
push -8
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -9
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
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
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# metto l'indirizzo del 1 metodo nell'heap 
push function1 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# CALL NODE di quicksort
# Control link
lfp
# parametri (2)
# ID rel
# ID funzionale
# recupero il valore del FP
push 3
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
# CALL NODE di filter
# Control link
lfp
# parametri (2)
# ID prec
# ID funzionale
# recupero il valore del FP
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push -4
lfp
# risalgo la catena statica 0 volte
add
lw
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -6
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -7
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
# setto l'AL
push -8
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -9
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
# setto l'AL
push -4
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -5
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
b label19
label18: 
push -1
label19:
srv
pop
pop
pop
pop
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js

function11:
cfp
lra
# Dichiarazioni della funzione 
# Body della funzione
# ID y
# ID normale (non funzionale) recupero il valore
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
# ID x
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
bless label24
# ID y
# ID normale (non funzionale) recupero il valore
push 2
lfp
# risalgo la catena statica 0 volte
add
lw
# ID x
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
beq label24
push 0
b label25
label24:  
push 1 
label25:
push 1
beq label22
push 1
b label23
label22:  
push 0 
label23:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function10:
cfp
lra
# Dichiarazioni della funzione 
# code generation FUN NODE inc
lfp
push function11
# ============= 
# Body della funzione
# CALL NODE di quicksort
# Control link
lfp
# parametri (2)
# ID inc
# ID funzionale
# recupero il valore del FP
push -2
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -8
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -9
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
srv
pop
pop
sra
pop
pop
sfp
lrv
lra
js

function13:
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
bless label28
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
beq label28
push 0
b label29
label28:  
push 1 
label29:
push 1
beq label26
push 1
b label27
label26:  
push 0 
label27:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function12:
cfp
lra
# Dichiarazioni della funzione 
# code generation FUN NODE dec
lfp
push function13
# ============= 
# Body della funzione
# CALL NODE di quicksort
# Control link
lfp
# parametri (2)
# ID dec
# ID funzionale
# recupero il valore del FP
push -2
lfp
# risalgo la catena statica 0 volte
add
lw
# recupero l'indirizzo della funzione 
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
# ID l
# ID normale (non funzionale) recupero il valore
push 1
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -8
lfp
# risalgo la catena statica 1 volte
lw
add
lw
# setto l'indirizzo a cui saltare
push -9
lfp
# risalgo la catena statica 1 volte
lw
add
lw
js
# ============= 
srv
pop
pop
sra
pop
pop
sfp
lrv
lra
js
