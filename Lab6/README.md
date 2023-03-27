Explicatii Lab 6 - Compulsory

Crearea unui joc care se joaca pe o tabla ce contine un numar de puncte plasate pe un cerc. Unele puncte sunt conectate cu altele prin linii. Initial liniile sunt
necolorate. Fiecare jucator are o culoare si trebuie sa incerce sa formeze un triunghi folosind culoare sa, sau sa evite ca adversarul sa creeze un triunghi.

Compulsory:
Cerinta: Crearea ferestrei principale, butoanelor, etc. Desenarea figurii in spatiul de joc in functie de nr de puncte si linii.

1. Crearea main frame-ului folosind Swing, adaugarea unui size si a unui tip  de layout
2. Crearea configuration panel-ului astfel: Label nr puncte; TextField nr puncte; Label nr linii; TextField nr linii; New game button
3. Crearea unui canvas pentru a desena tabla de joc => Crearea unei clase ce extine JPanel si suprascrierea metodei paintComponent astfel: este gasit mijlocul spatiului
de joc, sunt calculate coordonatele tuturor punctelor (in functie de unghi (360/nr puncte)) folosind sinus pentru y si cosinus pentru x. Apoi sunt desenate punctele si 
liniile, numarul de linii care trebuiesc desenate fiind un atribut al clasei, initializat in constructor
4. Crearea control panel-ului cu cele 4 butoane: load, save, reset, exit
5. Adaugarea celor 3 componente la main frame astfel: configuration panel in partea de sus (BorderLayout.NORTH), canvas-ul in mijloc (BorderLayout.CENTER) si 
control panel-ul in partea de jos (BorderLayout.SOUTH).
