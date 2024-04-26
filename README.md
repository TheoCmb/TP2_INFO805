# TP234_INFO805
### COMBE Théo

#### Ce repositorie sert de rendu pour les 3 TP.

##### Voici 2 exemples de simulation :

```>>> let prixHt = 200; let prixTtc =  prixHt * 119 / 100 .```

let prixHt = 200;
let prixTtc =  prixHt * 119 / 100 .

Generation de l'arbre :

```( ;  ( let  ( prixHt ) ( 200 )) ( let  ( prixTtc ) ( /  ( *  ( prixHt ) ( 119 )) ( 100 ))))```

Generation du code assembleur :

```
DATA SEGMENT
        prixHt DD
        prixTtc DD
DATA ENDS
CODE SEGMENT
        mov eax, 200
        mov prixHt, eax
        push eax
        mov eax, prixHt
        mov eax, 119
        pop ebx
        mul eax, ebx
        mov eax, 100
        pop ebx
        div eax, ebx
        mov eax, ebx
        mov prixTtc, eax
        push eax
CODE ENDS
```

```>>> 9*5+3*6;.```

Generation de l'arbre :

```( ;  ( +  ( *  ( 9 ) ( 5 )) ( *  ( 3 ) ( 6 ))))```

Generation du code assembleur :

```
DATA SEGMENT
DATA ENDS
CODE SEGMENT
        mov eax, 5
        pop ebx
        mul eax, ebx
        mov eax, 6
        pop ebx
        mul eax, ebx
        mov eax, null
        pop eax
        add eax, ebx
CODE ENDS
```
