# return address fittizio 
push 0

# creazione oggetto di classe Integer
# pusho l'0-esimo parametro della new sullo stack
push 10
# salvo l'0-esimo campo nell'heap
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
# metto l'indirizzo dell'0-esimo metodo nell'heap 
push function0 
lhp
sw
# incremento hp
lhp
push 1
add
# salvo hp
shp
# creazione oggetto di classe Printer
# metto hp sullo stack (object pointer)
lhp
# metto l'indirizzo dell'0-esimo metodo nell'heap 
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
# ID x
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 0 volte
add
lw
# setto l'AL
push -3
lfp
add
lw
# setto l'indirizzo a cui saltare
push -3
lfp
add
lw
push 0
add
lw
js
print
halt

function0:
cfp
lra
# Dichiarazioni del metodo 
# Body del metodo
# ID v
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
srv
sra
pop
pop
sfp
lrv
lra
js
