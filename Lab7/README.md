Explicatii Lab 7 : Compulsory

O harta de NxN este reprezentat ca o matrice, un numar de roboti trebuie sa exploreze toata harta. Initial robotii sunt plasati random si se pot misca in orice directie
, ei pot accesa un shared memory. Cand un robot ajunge pe o pozitie nevizitata, acesta extrage n tokeni din acea memorie si ii stocheaza in locatia de pe harta respectiva.

Compulsory:
Cerinta: Crearea unui model orientat-obiect, fiecare robot avand un nume, miscandu-se random pe harta si extragand tokeni. Simularea explorarii folosind thread-uri, folosirea
sincronizarii la extragerea tokenilor si la vizitarea celulelor.

1. Crearea clasei CellMap care reprezinta efectiv harta (un array boolean care contine pozitiile vizitate si un 3d array ce contine tokenii pentru fiecare celula)
2. Crearea clasei SharedMemory ce contine tokenii ( + metoda extractToken (synchronized) care extrage un numar de n tokeni din memorie), tokenii fiind numere de la 1 la n^3, amestecate
3. Crearea clasei Robot cu urmatoarele atribute: sharredMemory, cellMap, currRow, currCol, name, etc
4. Crearea metodei moveRandom in clasa Robot care genereaza un numar random de la 0 la 7 si in functie de numar robotul se misca pe harta (sus-jos-stanga-dreapta-diagonale)
5. Crearea metodei run in clasa Robot, care, atat timp cat nu este vizitata toata harta, muta robotii pe toata harta pana sunt vizitate toate celulele (folosind de asemenea
synchronized, ca 2 roboti sa nu poate extrage aceleasi token-uri). In momentul in care un robot extrage tokeni, se va afisa un mesaj pe ecran
6. In clasa main, crearea robotilor plasati pe pozitii random, dar diferite si crearea cate unui thread pentru fiecare robot
