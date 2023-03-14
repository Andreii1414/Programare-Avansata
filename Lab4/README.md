Explicatii Lab 4 - Compulsory

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
