Explicatii Laborator 3 Compulsory

Compulsory:
Cerinta: O retea sociala contine persoane si companii indentificate printr-un nume unic. In aceasta retea exista relatii de tipul persoana - persoana sau persoana - companie
si exista diferite tipuri de persoane in retea: programator, designer, etc. Se cere crearea unui model al problemei avand cel putin clasele Person si Company, ambele 
implementand java.util.Comparable. Se cere crearea interfetei Node prin care se obtine numele companiei sau al persoanei, clasele Person si Company trebuie sa implementeze
interfata Node. Crearea unei liste cu obiecte de tipul Node si printarea lor.

1. Crearea celor doua clase Person si Company, adaugarea atributelor specifice (name, etc) si a getter-elor si a setter-elor corespunzatoare.
2. Crearea interfetei Node care extinde java.util.Comparable pentru ca, atunci cand implementam interfata Node in Person si Company sa implementam si java.util.Comparable
3. Suprascrierea metodei compareTo pentru clasele Person si Company
4. Crearea mai multor obiecte de tipul Person si Company si adaugarea lor intr-o lista de tipul Node.
5. In final, printarea obiectelor din lista de tipul Node.


Homework:
Cerinta: Crearea modelului complet ce contine clasele: Person, Company, Programmer, Designer, fiecare persoana avand un birthDate si o proprietate specifica pe care
cealalta nu o are. Fiecare persoana va contine un Map cu relatii. Crearea unei clase Network ce contine o lista de tipul Node. Crearea unei metode care calculeaza
importanta unui nod (numarul de conexiuni cu alte noduri). Crearea unui Network ce contine persoane, companii, relatii si afisarea lor in ordinea importantei.

(in plus fata de compulsory)
1. Crearea claselor Programmer, Designer, clasele Programmer si Designer extinzand Person si avand cate o proprietate specifica (progammingLanguages pentru Programmer, designerType pentru Designer). Crearea de gettere si settere pentru aceste clase.
2. Crearea unui Map in clasele Person si Company (<Node, RelationshipType>, unde RelationshipType este un enum ce contine tipurile de relatii)
3. Crearea clasei Network ce contine un List de tipul Node si a getterelor si setterelor corespunzatoare.
4. Crearea metodei addNode in Network, pentru a adauga un nod in lista.
5. Crearea metodei addRelationship in Person si Company, cu ajutorul careia putem adauga o relatie in Map-urile celor doua persoane (sau persoanei si companiei) intre care se adauga o relatie.
6. Adaugarea la interfata Node a metodelor setImportance, getImportance, getRelationshipMap si implementarea lor in Person si Company, astfel incat sa putem seta importanta, sa putem obtine importanta sau Map-ul unui nod.
7. Crearea metodei computeImportanceOneNode care calculeaza importanta unui nod (size-ul map-ului) si apoi a metodei computeImportanceAllNodes care se foloseste de metoda descrisa anterior si calculeaza importanta pentru toate nodurile.
8. Crearea metodei getByImportance care returneaza lista de noduri sortata dupa importanta
9. Crearea in main a mai multor persoane, a mai multor companii, adaugarea de relatii intre persoane, respectiv intre persoane si companii, adaugarea de noduri intr-o noua retea. Sortarea folosind metoda getByImportance si printarea nodurilor sortate dupa importanta.
