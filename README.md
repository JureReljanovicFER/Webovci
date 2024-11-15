# StanBlog 

# Opis projekta
Ovaj projekt je reultat timskog rada u sklopu projeknog zadatka kolegija [Programsko inženjerstvo](https://www.fer.unizg.hr/predmet/proinz) na Fakultetu elektrotehnike i računarstva Sveučilišta u Zagrebu. 

Cilj ovog projekta je izraditi web aplikaciju pod nazivom StanBlog koja će omogućiti lakše komuniciranje i razmjenu informacija među stanarima u određenoj zgradi. Postoje mnoge prednosti stanovanja u dijeljenim stambenim objektima kao što su ušteda vremena i novca, ali često se javljaju problemi kod organiziranja određenih aktivnosti (radovi na stambenim objektima, održavanje i sl.) koje se tiču svih stanara. Aplikacija StanBlog ima za cilj riješiti te probleme i maksimalno olakšati komunikaciju i donošenje zajedničkih odluka u kojima moraju sudjelovati svi članovi pojedinog stambenog objekta.

# Funkcijski zahtjevi
Neprijavljeni korisnik može:
- prijaviti se u aplikaciju koristeći svoj Google račun

Obični korisnik (inicijator) može:

- pogledati popis svih stambenih objekata u koje je on uključen
- pogledati detalje vezane uz pojedini stambeni objekt
- dodati suvlasnike u pojedini stambeni objekt, ali samo ako je on predstavnik stanara u tom objektu
- započeti diskusiji o određenoj temi za određeni stambeni objekt, kojeg je on član
- izabrati želi li da diskusije bude javna ili privatna te izabrati kojim ostalim korisnicima želi omogućiti sudjelovanje (pisanje komentara) u sklopu diskusije
- ostavljati komentare u drugim diskusijama vezanim uz pojedini stambeni objekt u kojima ih je omogućeno sudjelovanje

Administrator (inicijator) može:

- dodati nove stambene objekte na stranici popisa stambenih objekata
- pregledati detalje vezane uz pojedini stambeni objekt
- dodati članove u pojedini stambeni objekt te odabrati njihovu ulogu u objektu (suvlasnik ili predstavnik stanara)
- dodati pojedine članove u aplikaciju, bez dodavanja u određeni stambeni objekt

Baza podataka (sudionik):

- pohranjuje sve podatke o korisnicima, njihovim ovlastima te s kojima su stambenima objektima povezani
- pohranjuje sve podatke o stambenim objektima (članovi pojedinog objekta te diskusije vezane uz objekt)
- pohranjuje sve podatke o pojedinim diskusijama (komentari, odgovori na komentare, status, te popis članova koji u njoj mogu sudjelovati)

StanPlan aplikacija:
-vanjska aplikacija koja služi za kreiranje sastanaka iz neke diskusije


# Tehnologije
- Java
- Spring Boot
- React
- Docker
- PostgreSQL

# Članovi tima 
- Jure Reljanović
- Hrvoje Katilović
- Franko Ćirić
- Gabriel Franković
- Lovro Mihaljević
- Ljubomir Jerončić
- Teodor Gregorić

# 📝 Licenca
[CC0]([https://www.fer.unizg.hr/predmet/proinz](https://creativecommons.org/public-domain/cc0/))
