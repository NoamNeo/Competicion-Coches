## División del trabajo

Al principio del proyecto, evaluad como grupo todas las clases que tiene que haber, y qué métodos públicos tiene que tener cada clase - es probable que haya métodos no listados, como getters. Por ejemplo, si se pide que hay que imprimir el listado de pilotos y sus escuderías, Piloto tendría que tener `mostrarPiloto():String` que devuelve por ejemplo `Ferrari - Schumacher` ; a su vez, Coche tiene que tener un método `devolverEscuderia():String` que nos devuelva la escudería (así, el Piloto puede implementar su método de mostrar llamando al de escudería).

Tras esta evaluación, un miembro del grupo genera un proyecto vacío en Github y todos trabajaréis contra ese.

La división del trabajo se hace de la siguiente forma (numeramos a la gente del grupo desde 1 hasta 4):

### Orden de la división de trabajos.

1. Ana
1. Gabi
1. Dani
1. Juan

### Primera fase, creación del esqueleto. Esta fase la puede hacer una sola persona, o repartiros el trabajo.

1. Creación del esqueleto de Coche y Piloto (métodos, etc, todo vacío).
1. Creación del esqueleto de Circuito y Carrera.
1. Creación del esqueleto de Competición.
1. Creación del Simulador.

### Segunda fase, implementación del proyecto. Cada miembro tiene que trabajar en la parte que le corresponde. Tenéis que dividir el trabajo como sigue:

1. Carrera completa (incluida la ordenación y array de puestos).
1. Competicion (añadir pilotos, arrancar campeonato, clasificación por pilotos).
1. Competicion (añadir carreras, clasificación por escuderías).
1. Coche, Piloto, Circuito y Simulador.
