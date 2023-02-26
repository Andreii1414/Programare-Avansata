Explicatii Laborator 2 Compulsory

Compulsory:
Cerinta: Creare unei instante pentru problema "Best Route", posibilitatea crearii de drumuri si locatii care au anumite informatii
Modelarea problemei avand cel putin 2 clase, Location si Roads, crearea de constructori, gettere si settere, implementarea metodei toString(), crearea de obiecte si printarea

1. Crearea celor doua clase Location si Roads adaugand urmatoarele atribute: pentru Location: name, type, x, y; pentru Road: length, speedLimit, type
2. Crearea celor doua enum-uri RoadType si LocationType pentru a specifica tipul de drum (express, highway, etc), respectiv tipul de locatie (airport, city, etc) 
3. Pentru ambele clase, crearea unui constructor default (pentru a putea initializa atributele mai tarziu, folosind setterele) si a unui constructor cu argumente care ofera
posibilitatea initializarii atributelor fara a folosi setterele
4. Pentru ambele clase, crearea de gettere care returneaza valoarea atributelor (name, length, speedLimit, etc) si crearea de settere care pot seta valoarea acestor atribute
5. Suprascrierea metodei toString in ambele clase folosind keyword-ul @Override, astfel incat aceasta metoda sa returneze un String care contine informatii despre Road, 
respectiv despre Location
6. In clasa Compulsory, am creat mai multe obiecte de tipul Road si de tipul Location si am initializat atributele folosind settere sau folosind constructorul corespunzator
7. Am printat informatii despre aceste obiecte folosind System.out.println() si metoda suprascrisa toString() din cele doua clase Road si Location
