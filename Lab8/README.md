Explicatii Lab8 - Compulsory

Compulsory:
Cerinta: Crearea unei baze relationale Oracle/Postgres/MySql/... si scrierea unui script SQL care creaza tabele. Crearea unei clase ce realizeaza conexiunea cu baza de date
, crearea de clase DAO si implementarea unui test.

1. Crearea bazei de date Oracle si a tabelelor folosind scriptul din directorul src/script
2. Crearea claselor Album, Artist, Genre, AssociativeTable si adaugarea atributelor
3. Adaugarea dependentelor in pom.xml
4. Crearea clasei Singleton care realizeaza conexiunea cu baza de date, avand metodele createConnection si closeConnection (+gettere si settere)
5. Crearea clasei DAO pentru Album (AlbumDao) si a 3 metode care gestioneaza tabelul Albums. selectAll selecteaza toate albumele din tabel, getById selecteaza albumul 
cu id-ul primit ca parametru, iar getByTitle selecteaza tabelul cu titlul primit ca parametru.
6. Implementarea unui test: rularea scriptului de creare, crearea a doua albume apoi afisarea folosind cele 3 metode: selectAll, getById/getByTitle.
