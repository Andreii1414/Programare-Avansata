Explicatii Lab 5 - Compulsory

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
