Explicatii Lab 4 - Compulsory + Homework

Cerinta: O problema ce contine studenti si proiecte. Fiecare student are o lista de proiecte admisibila. Un cuplaj este un set de perechi (student, project) astfel incat
fiecare student este alocat la cel mult in proiect, iar un proiect este alocat la cel mult un student. Se considera problema crearii unui cuplaj de cardinal maxim intre
studenti si proiecte.

Compulsory:
Cerinta: Crearea unui proiect Maven, modelarea problemei astfel incat studentii si proiectele sa aiba nume si sa fie comparabile. Crearea studentilor si a proiectelor 
descrisi in exemplu (3 studenti (S0,S1,S2) si 3 proiecte (P0,P1,P2);S0={P0,P1,P2}, S1={P0,P1}, S2={P0}) folosind stream-uri, adaugarea studentilor intr-un LinkedList,
a proiectelor intr-un TreeSet si printarea lor sortata dupa nume.

1. Crearea unui proiect Maven
2. Crearea claselor Student si Project, fiecare are un name si gettere si settere corespunzatoare. Student are de asemenea si o lista de proiecte admisibile.
3. Cele doua clase de mai sus implementeaza Comparable => suprascriu metoda compareTo
4. Suprascrierea metodei toString in cele doua clase.
5. Crearea de studenti si proiecte folosind stream-uri.
6. Adaugarea studentilor intr-un LinkedList folosind de asemenea stream-uri
7. Adaugarea proiectelor intr-un TreeSet folosind stream-uri
8. Sortarea studentilor (si apoi a proiectelor) folosind nume_clasa.stream.sorted() dupa nume si apoi printarea folosind forEach


Homework:
Cerinta: Crearea unei clase care descrie problema, scrierea unui query care returneaza nr de studenti cu mai putine preferinte decat media, generarea de studenti
si de proiecte cu nume fake si crearea unui algoritm greedy care rezolva problema

1. Crearea clasei Problem care descrie problema si contine o lista de studenti si un set de proiecte (+gettere, settere si constructori)
2. Crearea unei metode care returneaza o lista cu studentii care au mai putine preferinte decat media, astfel: calculul mediei (nr total de preferinte/nr de studenti)
si apoi folosirea API-ului Java Stream pentru a filtra studentii care au mai putine preferinte decat media calculata mai sus
3. Folosirea bibliotecii Java Faker (adaugand dependentele necesare in pom.xml) pentru a genera studenti si proiecte fake (si lista de preferinte a studentilor -> un nr
de proiecte random din proiectele generate random, pentru fiecare student)
4. Crearea unei metode care rezolva problema "The Student-Project Allocation Problem" folosind un algoritm greedy, astfel:
  4.1. Sortarea studentilor in ordinea crescatoare a preferintelor (de la cele mai putine preferinte la cele mai multe)
  4.2. Crearea unui TreeSet cu proiecte care nu au fost asignate si a unui Map in care vor fi adaugati studentii si proiectul asignat fiecaruia
  4.3. Parcurgerea listei de studenti si preferintelor lui
  4.4. In momentul in care in setul de proiecte admisibile ale unui student se gaseste un proiect care nu a fost asignat, se adauga studentul si proiectul in map
  si se sterge proiectul din setul proiectelor neasignate
  4.5. Returnarea map-ului
5. In main, apelarea metodei ce rezolva problema folosind un algoritm greedy pe proiectele si studentii generati random, dar si pe exemplul din enunt (3 studenti (S0,S1,S2) si 3 proiecte (P0,P1,P2);S0={P0,P1,P2}, S1={P0,P1}, S2={P0})
 
