Explicatii Lab8 - Compulsory + OPtional

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

Optional:
Cerinta: Implementarea claselor DAO, crearea unui model orientat-obiect, folosirea unui connection pool pentru conexiunea cu baza de date si crearea unui tool 
pentru a importa date dintr-un data set real.

1. Crearea claselor Dao pentru Artist, AssociativeTable si Genre si a metodelor: selectAll, getById, etc. 
2. Pentru fiecare dintre clasele ArtistDao, AlbumDao si GenreDao, crearea unui tool ce importa date dintr-un dataset, astfel: citeste date din fisierul CSV folosind 
un BufferedReader si creaza obiecte de tipul Artist/Album/Genre pentru fiecare linie din fisierul CSV, adaugand ulterior fiecare obiect la o lista, care va fi returnata la final
3. Realizarea conexiunii folosind HikariCP: adaugarea dependentei necesare in pom.xml, crearea unui fisier cu proprietati si realizarea efectiva a conexiunii folosind HikariConfig si HikariDataSource (in loc de clasa Singleton din Compulsory)
4. Testarea claselor Dao, creand obiecte din fiecare clasa si folosind metodele selectAll, getById, etc
5. Testarea tool-urilor, extragand o lista cu albume, artisti si genuri din data set-ul disponibil la: https://www.kaggle.com/datasets/notgibs/500-greatest-albums-of-all-time-rolling-stone
