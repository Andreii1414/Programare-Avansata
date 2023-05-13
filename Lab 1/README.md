Explicatii Laborator 1 Homework + Bonus

Homework:
Cerinta: creearea unei matrici Latin Square si printarea fiecarei linii si a fiecarei coloane, iar in cazul in care n (nr de linii si coloane) este prea mare, se printeaza
doar running time-ul executiei aplicatiei

1. Verific ca exista un singur argument la linia de comanda, in caz contrar, executia programului este terminata
2. Validez argumentul cu try si catch, daca argumentul nu este intreg, programul genereaza o exceptie si se termina, in caz contrar, executia continua
3. Creearea matricii:
- Parcurg fiecare linie, incepand cu prima (de la 0 la n-1) de la sfarsit la inceput (de la n-1 la 0)
- Folosesc doua variabile auxiliare k1 si k2 pentru a forma latin square-ul
- Parcurgand linia de la final, pun pe linie numerele de la j + 1 - k1 la 1, iar apoi, daca nu am ajuns la inceputul liniei (nu am ajuns doar daca linia = 0), pun 
in continuare numerele de la n cu ajutorul lui k2 (unde j este indicele coloanei)
- k1 creste dupa fiecare iteratie a lui i (unde i este indicele pentru linie)
4. Printez matricea doar daca n nu este foarte mare
5. Concatenez fiecare linie si fiecare coloana folosind doua for-uri: line = line + latinSquare[i][j]; col = col + latinSquare[j][i];
6. Afisez liniile si coloanele doar daca n nu este foarte mare
7. La final, printez running time-ul scazand din timpul in milisecunde de la finalul executiei, timpul in milisecunde de la inceputul executiei, folosind
System.currentTimeMillis();

Bonus:
Cerinta: Crearea unei matrici de adiacenta A a unui graf Cn si calculul fiecarei matrici A^2, ..., A^n

1. Verificarea numarului de argumente si a argumentului, exact ca la Homework
2. Crearea matricii de adiacenta:
- In Cn, fiecare nod are gradul 2, asadar am creeat o legatura intre fiecare nod si vecinii sai, in functie de indici (legatura intre i si i-1 si intre i si i+1)
- Am tratat la inceput exceptia, adaugand legatura intre nodul 0 si nodul n-1 (si invers), deoarece, n-1 este nod anterior pentru 0, iar 0 este nod urmator pentru n-1
- Intr-un for am creeat si celelalte legaturi intre i si i+1, respectiv i+1 si i
3. Folosindu-ma de metoda "mul" care returneaza un tablou bidimensional, inmultind doua matrici primite ca argument (inmultire clasica a matricilor, fiecare element de
pe linie * fiecare element de pe coloana), am calculat A^2, A^3, ..., A^n
4. Am printat fiecare A, A^2, ..., A^n folosind metoda Print care face o printare obisnuita a unei matrici primita ca argument

Bonus:
Cerinta: Crearea unei matrici de adiacenta pentru un graf regulat.

1. Verificarea numarului de argumente si a argumentelor
2. Crearea matricii de adiacenta:
- Pentru fiecare nod, se iau vecinii din stanga si din dreapta de m/2 ori (m fiind gradul) - sunt tratate si cazurile in care vecinul din stanga ar fi < 0 iar cel din dreapta >= nr noduri
- Daca gradul este impar, se ia si un vecin secundar (deoarece, luand cate doi vecini, nu ar functiona si pt grafurile regulate cu nr impar de noduri)
3. Printarea matricii
