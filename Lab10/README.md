Explicatii Lab 10 - Compulsory + Homework

Cerinta: Implementarea jocului Gomoku, aplicatia avand 2 parti: server (responsabil cu managementul jocului) si client ( va comunica cu serverul si va trimite 
comenzi catre acesta)

Compulsory: 
Cerinta: Crearea proiectelor ServerApplication si ClientApplication si a claselor GameServer, ClientThread si GameClient

1. Crearea proiectului ServerApplication
2. Crearea clasei GameServer care creaza un ServerSocket care ruleaza la un anumit port. Server-ul va primi comenzi de la client si va crea CientThread-uri pentru 
acestia
3. Crearea clasei ClientThread: primeste request-urile de la server si: daca a primit comanda "stop", returneaza la client mesajul "Server stopped" si opreste
server-ul folosind System.exit(0); daca primeste orice alta comanda, returneaza la client mesajul "Server received the request..."
4. Crearea proiectului ClientApplication
5. Crearea clasei GameClient care trimite comenzi catre server si primeste unul dintre raspunsurile de mai sus. Client-ul se va opri cand este citit cuvantul "exit"

Homework:
Cerinta: implementarea logicii jocului

1. Crearea claselor Game, Board si Player si a logicii jocului. Fiecare player are un nume si un simbol.
2. Implementarea clasei Board care contine: o metoda care verifica daca harta este plina, o metoda care printeaza harta, o metoda care inregistreaza 
o mutare a unui jucator, etc.
3. In clasa Game se inregistreaza mutarile fiecarui jucator si se verifica daca o mutare este castigatoare (sus, jos, stanga, dreapta si pe diagonale)
4. Implementarea unui timer astfel incat fiecare jucator are un anumit timp total, daca timpul total se scurge, jucatorul pierde
