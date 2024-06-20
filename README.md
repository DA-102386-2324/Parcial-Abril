## Configuració de Firebase
### Per integrar Firebase Realtime Database, s'ha seguit el següent procés:

1- Afegir Firebase al projecte d'Android.

2- Configurar les regles de la base de dades per permetre l'accés de lectura i escriptura.

3- Implementar la lògica amb Realtime Database per llegir i escriure dades en temps real des de l'activitat de la partida.

4- Sincronització del Joc

La sincronització del joc en temps real s'ha implementat de la següent manera:

Quan un jugador fa un moviment, s'actualitzen les dades corresponents a Firebase.
Els canvis en Firebase són escoltats per GameActivity, que actualitza l'estat del joc localment.
Llavors la classe GameView es redibuixa automàticament cada vegada que hi ha un canvi en l'estat del joc.

## Coses a tenir en compte

El codi segueix una implementació lògica, es criden les variables i els getters i els setters. 
El codi compila però l'app crashee. He intentat trobar la solució pero cap debug em donava pistes dels errors, ja que no en sortien cap a la consola.
A continuació t'adjunto el link a la base de dades de la Realtime Database de FireBase:
https://dots-and-boxes-ffaf0-default-rtdb.europe-west1.firebasedatabase.app/
Aqui està la estructura amb els components necessaris per fer una partida entre dos dispositius.
Tot i que desconec si funcione o no, trobo que la implementació és bona.

