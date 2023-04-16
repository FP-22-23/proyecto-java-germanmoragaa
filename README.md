# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Germán Moraga Fontán  uvus: germorfon

Trabajaremos con un dataset de jugadores de la NBA de la temporada 2018-2019. Ofrece una gran variedad de datos del jugador,
su nombre, altura, salario, puntos por partido, asistencias por partidos, si ha estado en las finales o no, la fecha en la que fue drafteado y las dos ultimas ciudadades en las que jugó.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.NBAplayer**: Paquete que contiene los tipos del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto
    * **NBA stats 2018-2019.csv**: Dataset sobre los jugadores de la NBA.
    
## Estructura del *dataset*

Aqui se encuentra el data set original: https://www.kaggle.com/datasets/schmadam97/nba-regular-season-stats-20182019

Este está compuesto por 8 columnas, con la siguiente descripción:

* **Name**: de tipo String, representa los nombres de los jugadores
* **Height**: de tipo Integer, representa la altura de los jugadores en pulgadas
* **Age**: de tipo Integer, representa la hora del inicio de la carrera
* **Salary**: de tipo Integer, representa el salario de los jugadores
* **Points**: de tipo Double, representa los puntos por partidos de los jugadores
* **Assists**: de tipo Double, representa las asistencias por partidos de los jugadores
* **Finals**: de tipo Boolean, representa si los jugadores han aparecido en las finales de la NBA
* **Drafted**: de tipo LocalDate, representa la fecha del drafteo del jugador
* **Partidos**: de tipo List, representa la ciudad en la que se jugaron los dos ultimos partidos

Además, el dataset está formado por 522 filas. La primera es la cabecera y las demás son los registros. 

## Tipos implementados

Aqui describiremos los tipos que usaremos en el proyecto.

### Tipo Base
Descripción breve del tipo base.

**Propiedades**:

- Name, de tipo String, consultable. 
- Height, de tipo Integer, consultable. 
- Age, de tipo Integer, consultable. 
- Salary, de tipo Integer, consultable y modificable. 
- Points, de tipo Double, consultable y modificable. 
- Assists, de tipo Double, consultable y modificable. 
- Finals, de tipo Boolean, consultable. 
- Drafted, de tipo LocalDate, consultable. 
- Rol, de tipo rol, consultable.
- Partidos, de tipo list, consultable.

- 
**Constructores**: 

- C1: Inicializa todas las variables de instancia de la clase, incluyendo el nombre, altura, edad, salario, puntos, asistencias, si ha participado en finales, la fecha de selección en el draft y los dos últimos partidos. 
Tambien hacemos uso de la clase Checkers para asegurarnos de que los valores proporcionados sean válidos.
- C2: Este constructor es más simple y solo tiene parámetros para el nombre y el salario del jugador. 
Cuenta con una restriccion para que el salario dado cumpla con el salario mínimo de la NBA.


**Restricciones**:
 
- R1: La edad no puede ser menor a 18 años.
- R2: El salario no puede menor al establecido por la NBA, 925258 $.
- R3: La fecha de drafteo no puede ser anterior al 23 de junio de 2017, ya que este dia fue la fecha del draft para la temporada 18-19.


**Criterio de igualdad**: Se basa en la comparación de la edad, altura y rol, ya que los jugadores con estos atributos parecidos podrian cumplir la misma función.
 El método equals() devuelve true si los tres atributos son iguales en los dos objetos.

**Criterio de ordenación**: Los objetos BasketballPlayer deben ser ordenados en función del rol del jugador. Si hay jugadores con el mismo rol, por los puntos del jugador como segundo criterio de ordenación. Si aún hay jugadores con los mismos puntos, se utiliza el número de asistencias.

**Otras operaciones**:
 
-	getRol(): Nos devuelve el rol del jugador en función de la suma de sus puntos y asistencias por partido. 
Estos roles son: Benchwarmer si su suma de puntos y asistencias es menor a 5, Role Player si es menor a 15, Starter si es menor a 30, 
y Superstar si es mayor o igual a 30.


#### Tipos auxiliares
No hago uso de tipos auxiliares.

### Factoría
La factoría sirve para leer y parsear los datos de los jugadores de la NBA desde nuestro archivo CSV.
- leerJugadores: recibe una cadena de texto que representa la ruta y nombre de un archivo CSV. Hacemos uso de Files.lines para obtener un Stream con las 
líneas del archivo, salta la primera línea, aplica el método parsePlayer a cada línea usando map y crea un objeto 
ContenedorNBA objetos BasketballPlayer y devuelve ese objeto.
- parsePlayer: recibe una línea de texto con los datos de un jugador. Este método separa los campos de la línea utilizando split, 
parsea los datos de cada campo y crea un objeto BasketballPlayer con los datos obtenidos, este es el objeto que devuelve.

### Tipo Contenedor

Mi tipo contenedor cuenta con una lista de objetos de la clase BasketballPlayer y proporciona métodos para operar en esta lista, como añadir y eliminar jugadores, 
filtrarlos entre otras cosas.

**Propiedades**:

- jugadores, de tipo lista de objetos BasketballPlayer, consultable y modificable. 

- 
**Constructores**: 

- C1: Constructor sin argumentos que crea un objeto ContenedorNBA vacío, sin jugadores.
- C2: Constructor que toma un objeto Stream<BasketballPlayer> como argumento, y crea un objeto ContenedorNBA a partir de una colección de jugadores.
- C3: Constructor que toma una colección de jugadores como argumento, y crea un objeto ContenedorNBA a partir de esta colección.

**Criterio de igualdad**: El criterio de igualdad se basa en la comparación de dos objetos ContenedorNBA, los cuales son iguales si contienen las mismas listas de jugadores en el mismo orden.

**Otras operaciones**:
 
-getNumJugadores(): devuelve el número de jugadores.

-anyadirJugador(BasketballPlayer jugador): añade un jugador al contenedor.

-anyadirJugadores(Collection<BasketballPlayer> jugadores): añade una colección de jugadores al contenedor.

-eliminarJugador(BasketballPlayer jugador): elimina un jugador del contenedor.

-existeJugadorQueGaneMas(Integer n): devuelve true si hay algún jugador en el contenedor que gane más de n dólares.

-mediaPPP(): devuelve la media de los puntos por partido de todos los jugadores del contenedor.

-filtrarPorSalario(Integer minSal): devuelve una lista de jugadores cuyo salario es mayor o igual que minSal.

-agruparPorNombre(): devuelve un mapa que agrupa el nombre de los jugadores con sus salarios.

-acumularPorPuntos(): devuelve un mapa que agrupa las edades de los jugadores con la suma de PPP de todos los de dicha edad.
