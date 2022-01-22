# InchirieriAuto

Aplicatia gestioneaza o baza de date a unei companii de inchirieri autot, supusa urmatoarelor cerinte:
  1. Exista un singur tip de utilizator, clientul
  2. Un client isi poate crea un cont sau se poate autentifica daca are deja un cont creat, print-un username si o parola
  3. Clientul este identificat unic atat prin username cat si prin CNP
  4. In baza de date avem mai multe autovehicule identificate unic prin numarul de inmatriculare acestea mai au marca, model, consumul, tipul de carburant si pret 
  5. Un client poate inchiria mai multe auoturisme, pentru fiecare inchiriere datele sunt introduse intr-un contract in care se specifica CNP ul clientului, numarul autoturismului, durata si pretul final calculat dupa reducere
  6. Istoricul pastreaza informatii despre data de inceput si data de final a contractului 


Manual de utilizare

La lansarea in executie a aplicatiei suntem intampinati de fereastra “Login” de unde putem alege 
daca dorim ca sa ne autentificam sau sa cream un nou user. Daca am creat un nou cont atunci este
nevoie sa apasam pe butonul de autentificare pentru a intra in aplicatie, daca datele au fost 
introduse corect o sa apara o noua fereastra unde utilizatorul  o sa poata vedea masinile 
disponibile si pretul lor, acestea sunt impartite in 3 categorii.  Untilizatorul este nevoit 
sa introduca CNP-ul, numele, prenume si durata inchirierii iar masina o alege in functie de numarul 
de inmatriculare. Dupa ce totul a fost completat utilizatorul poate sa verifice daca datele din contract 
sunt corecte afisand ultimul contract realizat.

![31](https://user-images.githubusercontent.com/70382324/150644436-4a33ac0c-c3e3-428c-b931-f600c4daa883.png)

In campurile libere se afiseaza datele contractului dupace este apasat butonul „ACTUALIZARE ULTIM CONTRACT”

![32](https://user-images.githubusercontent.com/70382324/150644438-5d3f1116-bf71-42d3-9b3f-9f09f7c3eba0.png)
