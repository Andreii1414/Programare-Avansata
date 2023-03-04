Explicatii Laborator 2 Compulsory, Homework

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

Homework:
Cerinta: Crearea unei clase care descrie o instanta a problemei, suprascrierea metodei equals pentru Location si Road, crearea unor clase diferite pentru tipurile de road sau location (city, gas station, highway, etc), locatiile avand proprietati specifice (gas price, population, etc). Implementarea unei metode care verifica daca instanta este valida. Implementarea unui algoritm care verifica daca este posibil sa ajungi de la o locatie la alta folosind drumurile date (-). Adaugarea de doc comments si folosirea javadoc.

1. Crearea clasei BestRouteInstance in care poate fi descrisa o instanta a problemei, avand urmatoarele atribute: o lista de Roads si o lista de Locations
2. Suprascrierea metodei Object.equals in cele doua clase Road si Location care verifica daca obiectul de tipul Road sau Location (this) este egal cu un alt obiect
3. Eliminarea enum-urilor si crearea claselor City, Airport si GasStation, cu atribute specifice (population, area, number_of_terminals,gas_price) si a claselor Express, Highway, Country care inlocuiesc enum-ul RoadType.
4. Implementarea metodei isValid() in clasa BestRouteInstance care verifica daca o instanta este valida. Metoda face 3 verificari: verifica daca exista locatii la fel in acea instanta, verifica daca exista drumuri la fel in acea instanta si verifica daca pentru fiecare drum, lungimea acestuia este mai mica decat distanta euclidiana dintre cele doua locatii.
5. Scrierera de comentarii si generarea documentatiei folosind javadoc
