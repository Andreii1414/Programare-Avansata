Explicatii Lab 5 - Compulsory + Homework

Scrierea unei aplicatii care gestioneaza un catalog cu documente (articol, carte, etc). Fiecare document poate avea un path sau un url, un id unic, un nume, si tag-uri 
care sunt perechi nume-valoare.

Compulsory:
Cerinta: Crearea unui model orientat-obiect al problemei continand cel putin clasele Document si Catalog. Crearea unei clase care se ocupa de operatiile externe asupra
catalogului. Implementarea metodelor: add, toString, save, load

1. Crearea claselor Document si Catalog avand atributele specificate in cerinta (+gettere, settere si constructori)
2. Crearea clasei Tag ce reprezinta un tag al unui document (un document poate avea o lista de tag-uri)
3. Crearea clasei CatalogManager.
4. Crearea metodelor addDocument, removeDocument si toString in clasa Catalog
5. Crearea acelorasi metode in CatalogManager, folosind metodele create in Catalog
6. Folosirea bibliotecii Jackson (adaugand dependentele necesare in pom.xml)
7. Cu ajutorul bibliotecii Jackson, creez metoda save care salveaza catalogul la path-ul primit ca argument in metoda (folosind ObjectMapper)
8. Crearea metodei load, care, de asemenea, foloseste ObjectMapper pentru a incarca un catalog dintr-un fisier extern, intr-un obiect de tipul CatalogManager
9. Exemplificarea in main (crearea unui Catalog si a unui CatalogManager si salvarea acestuia intr-un fisier, incarcarea catalogului din fisier intr-un alt obiect de 
tipul CatalogManager)


Homework:
Cerinta: Reprezentarea fiecarei comenzi folosind clase si o alta interfata sau clasa abstracta pentru comanda. Crearea de exceptii custom si crearea unui jar si folosirea aplicatiei din terminal

1. Crearea clasei abstracte Command ce contine metoda abstracta exeCmd(Catalog catalog) care va fi implementata in toate comenzile
2. Crearea unei exceptii custom care va fi folosita pentru a semnala informatii invalide
3. Crearea claselor pentru fiecare comanda (extinzand clasa Command) si suprascrierea metodei exeCmd:
  - AddComand -> adauga un document in catalog verificand (folosind exceptia custom) daca documentul are un id, un nume si un path/url valid
  - ListCommand -> printeaza toate documentele din catalog, daca nu exista niciun document in catalog, este generata o exceptie
  - ToStringCommand -> printeaza tot catalogul (daca nu este gol)
  - SaveCommand -> contine un atribut fileName si salveaza catalogul in acel fisier folosind Jackson (daca catalogul nu este gol)
  - LoadCommand -> contine un atribut fileName si incarca in catalog documentele din acel fisier folosind Jackson
  - ViewCommand -> contine un atribut id si deschide documentul cu acel id verificand daca este document local sau un document de pe o pagina web
  - ReportCommand -> foloseste template-ul din Templates/report_template.ftl si creaza un fisier .html ce contine informatiile din catalog (header: id, nume, path/Url, tags; body: lista documente; Fiecare document: id, nume, path/url, lista tag-uri; Fiecare tag: nume, valoare)
4. Crearea executabilului JAR si lansarea aplicatiei din consola folosind "java -jar path"
