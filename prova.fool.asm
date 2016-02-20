# return address fittizio 
push 0

# pusho il 0 parametro della new sullo stack
# pusho il 0 parametro della new sullo stack
push 50000
# pusho il 1 parametro della new sullo stack
push 40000
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
push function4 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# pusho il 0 parametro della new sullo stack
push 20000
# pusho il 1 parametro della new sullo stack
push 5000
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
#setto il CL
lfp
# ID myTradingAcc
# ID normale (non funzionale) recupero il valore
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -2
lfp
add
lw
# setto l'indirizzo a cui saltare
push -2
lfp
add
lw
push 1
add
lw
js

# ID myLoan
# ID normale (non funzionale) recupero il valore
push -4
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
#setto il CL
lfp
# setto l'AL
push -4
lfp
add
lw
# setto l'indirizzo a cui saltare
push -4
lfp
add
lw
push 0
add
lw
js
b label9
label8: 
push 0
label9:
print
halt

function0:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
# ID money
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
# ID invested
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
# ID loan
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

function3:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
push 30000
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
add
bless label2
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
add
push 30000
beq label2
push 0
b label3
label2:  
push 1 
label3:
push 1
beq label0
push -1
b label1
label0: 
# pusho il 0 parametro della new sullo stack
#setto il CL
lfp
# setto l'AL
push -1
lfp
lw
add
lw
# setto l'indirizzo a cui saltare
push -1
lfp
lw
add
lw
push 0
add
lw
js
# salvo il campo 0 nell'heap
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
label1:
srv
sra
pop
pop
sfp
lrv
lra
js

function4:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
push 20000
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
bless label6
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
push 20000
beq label6
push 0
b label7
label6:  
push 1 
label7:
push 1
beq label4
push -1
b label5
label4: 
# pusho il 0 parametro della new sullo stack
#setto il CL
lfp
# setto l'AL
push -1
lfp
lw
add
lw
# setto l'indirizzo a cui saltare
push -1
lfp
lw
add
lw
push 0
add
lw
js
# pusho il 1 parametro della new sullo stack
#setto il CL
lfp
# setto l'AL
push -1
lfp
lw
add
lw
# setto l'indirizzo a cui saltare
push -1
lfp
lw
add
lw
push 1
add
lw
js
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
label5:
srv
sra
pop
pop
sfp
lrv
lra
js
