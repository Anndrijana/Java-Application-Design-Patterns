## Opis zahteva za projekat iz predmeta Dizajnerski obrasci za 2019/2020
Korišćenjem *Java Swing* implementirati desktop aplikaciju za rad sa 2D grafikom. Aplikacija mora podržavati funkcionalnosti koje su rađene u projektnom zadatku na predmetu Objektno orijentisane informacione tehnologije.

![5](https://user-images.githubusercontent.com/61964257/145068668-d9b84b4e-d925-4386-9e67-38887af872fc.PNG)
Izmene/Dodatne funkcionalnosti:
1. crtanje oblika različitim bojama (boja ivice i boja unutrašnjosti) za šta je potrebno koristiti *JColorChooser* klasu,
2. unutrašnjost oblika krug sa rupom treba da bude transparentna (*java.awt.Graphics2D*, *java.awt.Shape*, *java.awt.geom.Area*, *java.awt.geom.Ellipse2D*),
3. aplikacija mora biti realizovan u skladu sa MVC arhitektonskim obrascem,
4. dodavanje, brisanje i modifikacija šestougla (*hexagon*) koristeći Adapter obrazac za hexagon.jar,
5. poništavanje izvršenih komandi (*undo* funkcionalnost) – *Command* i *Prototype* obrazac, ponovno izvršenje poništenih komandi (*redo* funkcionalnost) – *Command* i *Prototype* obrazac, *undo* i *redo* dugme treba da budu dostupni samo kada je dostupna i funkcionalnost,
6. generisanje i prikaz loga izvršenih komandi u okviru aplikacije,
7. zapis u tekstualnu datoteku loga izvršenih komandi na eksterni memorijski medijum, zapis kompletnog crteža (*Serialization*) na eksterni memorijski medijum, - *Strategy* obrazac,
8. učitavanje tekstualne datoteke koja sadrži log izvršenih komandi i na osnovu sadržaja, kreiranje odgovarajućeg crteža, komandu po komandu u interakciji sa korisnikom, učitavanje kompletnog crteža,
9. promenu pozicije oblika po Z osi, *To Front* (pozicija po pozicija), *To Back* (pozicija po pozicija), *Bring To Front* (na najvišu poziciju), *Bring To Back* (na najnižu poziciju),
10. prikazati trenutno aktivne boje za crtanje ivice i popunjavanje oblika, klikom na boju, otvara se dijalog sa mogućnošću promene trenutno aktivne boje,
11. omogućiti selekciju više oblika,

![6](https://user-images.githubusercontent.com/61964257/145070172-bbf913eb-714f-4604-8068-60aaee2dcc37.PNG)
12. dugme za brisanje treba da bude dostupno samo u slučaju da postoje selektovani objekti – *Observer* obrazac,

![8](https://user-images.githubusercontent.com/61964257/145070183-391dcd84-fd6d-4ec1-a27f-1797937f99e3.PNG)
13. dugme za modifikaciju treba da bude dostupan samo u slučaju kada je selektovan samo jedan oblik – *Observer* obrazac.

![7](https://user-images.githubusercontent.com/61964257/145070181-8b868498-4c18-4188-a24b-92e2e9bdc599.PNG)

### :heavy_exclamation_mark: Pojašnjenja funkcionisanja aplikacije:

- sve aktivnosti korisnika vezano za crtanje treba da budu sačuvane u log-u, to podrazumeva i logovanje selekcije, kao i *To Front*, *To Back*, *Bring To Front* i *Bring To Back* funkcionalnosti, *undo*  i *redo*.

![9](https://user-images.githubusercontent.com/61964257/145070184-15f34d79-e047-4e85-a43f-713004882a57.PNG)

- selektovani oblik, nakon modifikacije, treba da ostane selektovan.

- ukoliko se nakon *undo* funkcionalnosti izvrši neka nova funkcionalnost (nacrta novi oblik, modifikuje postojeći…), *redo* funkcionalnost ne bi trebalo da bude dostupna.
