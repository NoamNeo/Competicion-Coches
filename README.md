# CompeticionCoches

Este es el ejercicio de la segunda evaluación. Utilizando todo lo aprendido hasta ahora, tenéis que simular una competición de Formula 1. Para ello tendréis que crear varias clases que representen objetos/conceptos del mundo real, como Coche o Carrera, y una clase que controle el flujo del programa.

En nuestro sistema, tendremos **coches** y **pilotos**. Un piloto tiene SIEMPRE asignado un coche, y siempre el mismo coche. A lo largo de una **competición** se harán varias **carreras** (una carrera ocurre en un **circuito**). Simulando los resultados de las carreras, la competición nos dirá cómo ha sido la clasificación.

## Reglas

**Es obligatorio:**

- Utilizar clases y objetos
- Implementar los constructores adecuados
- Implementar getters y setters (solo cuando tenga sentido)
- Implementar la lógica de cada objeto dentro del objeto
- Usar condicionales y bucles cuando sea necesario
- Usar arrays de objetos cuando sea necesario
- Usar composición cuando sea necesario
- Hacer entrada de datos por teclado (Scanner)
- Hacer salida de datos por consola
- Tener un repositorio GitHub con commits repartidos entre los miembros del grupo
- Que cada miembro del grupo se encargue de una única sección

**Está prohibido utilizar contenidos que aún no se han dado en el curso:**

- Colecciones/Streams (List, Set, Map…)
- Herencia (extends…)
- Interfaces (implements…)
- Excepciones
- Librerías externas

## Clases y objetos a implementar

### Coche

Representa a un coche en el mundo real. De los coches queremos almacenar la **escudería**, la **velocidad máxima** y la **fiabilidad**; la fiabilidad es un parámetro entre 0 y 1 que nos dice la probabilidad que hay de que un coche se rompa por cada 5 km de carrera.
NO debemos acceder a la fiabilidad directamente, sino que el coche tiene un método `acabaCarrera(kilometros:int):boolean` que podremos usar para saber si acaba una carrera.

### Piloto

Representa a un piloto. Un piloto tendrá un nombre, una edad y un coche asignado (el coche del piloto no cambia en ningún momento). También tendrá un parámetro “habilidad” entre 0,6 y 1 que nos indica cómo de bueno es el piloto; lo usaremos para calcular la velocidad media a la que ha hecho una carrera.

- NO debemos acceder al parámetro de habilidad directamente, sino que el piloto necesita un método `velocidadMedia():double` que nos devuelva, cada vez que lo llamamos, una velocidad media en función de su habilidad, la velocidad máxima del coche, un parámetro aleatorio y la fiabilidad del coche.
  - Por ejemplo, una fórmula podría ser: `coche.getVelocidadMaxima() * habilidad * rand.nextDouble(0.9,1)`. En ese caso, un coche con velocidad máxima 300 y un piloto con habilidad 1 iría a un valor entre 270 y 300.
- El valor de este parámetro se generará cuando creemos un piloto, en su constructor. El constructor, entre sus parámetros, recibirá un String “habilidad”: si su valor es “Excelente” asignará un valor aleatorio entre 0,9 y 1 al parámetro interno; “Bueno” asignará entre 0,8 y 0,9; “Mediocre” entre 0,7 y 0,8; si recibe otra cosa, le asignará 0,6 directamente.
  - El objetivo es que al crear Pilotos no se nos pida un valor numérico para su habilidad, sino que asigne un valor numérico en función del texto que le digamos.

### Circuito

Representa un circuito (por ejemplo, Jarama). De un circuito queremos almacenar el **nombre** y la **longitud** en kilómetros. Además, cada vez que creemos una carrera para un circuito, en el circuito tenemos que almacenar dicha carrera en un array. Para ello, se implementará un método `añadirCarrera(carrera:Carrera): void`.
Además, para un circuito tenemos que añadir un método que devuelva cuantas carreras se han hecho en el mismo `obtenerCarrerasTotales(): int`.

### Carrera

Representa una carrera concreta en un circuito. De una carrera tenemos que saber si ya se corrido o no (para no repetir la carrera), de qué circuito es, cuantas vueltas tiene, de qué temporada es, el array de pilotos que participan y un array con los mismos pilotos, pero ordenados por puesto en la carrera. Además, tiene que tener un método que devuelva la longitud total en función de la del circuito y de las vueltas al mismo.
Una carrera tiene un método `ejecutarCarrera():boolean` que simula la carrera si nunca se ha corrido y devuelve “true”, o devuelve “false” si ya se había corrido.

- Cuando una carrera se simula:
  - Se calcula la velocidad media de cada piloto, y se imprime “Fulanito va a una media 295 km/h”.
  - Se calcula con la fiabilidad de los coches si un coche ha acabado la carrera o no - cuantos más kilómetros tenga la carrera, más fácil que un coche rompa. Si un coche no acaba, simplemente se le pone velocidad media 0.
  - Se hace un array ordenado por velocidad media.
  - **CONSEJO**: la forma más sencilla es hacer una ordenación por inserción.

### Competicion

Representa una competición completa. Tendrá un nombre; además, una competición tiene que mantener un listado de participantes y un listado de carreras - con ese listado, generará un listado de carreras. NO se crean directamente en el constructor, sino que:

- Tiene un método `anhadirPiloto(piloto:Piloto):boolean` que añade un piloto a la lista sólo si:
  - El piloto no está en la lista aún.
  - La competición no ha empezado aún (no ha habido carreras).
- Tiene un método `anhadirCarrera(circuito:Circuito, vueltas:int):boolean` que añade una carrera nueva sólo si:
  - No ha comenzado el campeonato aún.
  - No hay otra carrera en el mismo circuito en el campeonato.
- Tiene un método `arrancarCampeonato():boolean` que ejecuta todas las carreras una a una. Si ya se había ejecutado el método, no las simula de nuevo y devuelve false; en caso contrario las ejecuta y devuelve true.
- Tiene un método `imprimirResultado():void` que imprime el listado de pilotos ordenados por puntuación total. Para ello, tiene que recuperar sus puntuaciones de cada una de las carreras. Por simplicidad, un piloto obtiene 10 puntos si queda de primero en una carrera, 8 puntos si es segundo, 5 puntos si es tercero.
- Tiene un método `imprimirResultadoEscudería():void` que hace lo mismo que el anterior, pero no a nivel de Piloto sino de Escudería (tendrá que sumar los puntos de los pilotos que pertenezcan a la misma escudería). _Hint: no hemos trabajado con mapas. Así que primero recorre el array de pilotos contando cuantas escuderías hay y luego crea un array de escuderías, un array de puntos por escudería, y usa esos para ordenar_.

### Simulador

Esta es la clase que orquesta toda la competición. En esta clase hay que:

- Crear 6 coches de 3 escuderías (2 coches por escudería).
- Crear 6 pilotos a los que se añaden sus respectivos coches.
- Crear 4 circuitos.
- Crear 2 competiciones. Para cada una:
  - Añade 3 carreras.
  - Añade a todos los pilotos.
  - Arranca el campeonato
  - Imprime la clasificación final por pilotos y por escuderías.
  - Intenta ejecutarla de nuevo (no deberían de cambiar los resultados).

### _Trabajo extra_

En todas las clases/métodos hay que imprimir la información correcta. Por ejemplo, cuando llamamos a “anhadirPiloto()” a una competición, imprimimos en la propia función “Anhadiendo el piloto Menganito a la competición Asd”. Si no podemos añadirlo, imprimimos que no se ha podido y la razón.

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
