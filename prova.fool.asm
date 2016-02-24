# return address fittizio 
push 0

# creazione oggetto di classe A
# metto hp sullo stack (object pointer)
lhp
# caso particolare: classe senza campi ne metodi
# incremento hp
lhp
push 1
add
# salvo hp
shp
# creazione oggetto di classe A
# metto hp sullo stack (object pointer)
lhp
# caso particolare: classe senza campi ne metodi
# incremento hp
lhp
push 1
add
# salvo hp
shp

# ID x
# ID normale (non funzionale) recupero il valore
push -2
lfp
# risalgo la catena statica 0 volte
add
lw
# ID y
# ID normale (non funzionale) recupero il valore
push -3
lfp
# risalgo la catena statica 0 volte
add
lw
beq label0
push 0
b label1
label0:  
push 1 
label1:
print
halt
