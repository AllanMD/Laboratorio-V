Que es Maven
- Maven es una herramienta cuyo objetivo es simplificar los procesos de build (compilar y generar ejecutables a partir del c�digo fuente).
Posee la capacidad de realizar ciertas tareas claramente definidas, como la compilaci�n del c�digo y su empaquetado. 
Es decir, hace posible la creaci�n de software con dependencias incluidas dentro de la estructura del JAR. 
Es necesario definir todas las dependencias del proyecto (librer�as externas utilizadas) en un fichero propio de todo proyecto Maven,
el POM (Project Object Model). Este es un archivo en formato XML que contiene todo lo necesario para que a la hora de generar el fichero 
ejecutable de nuestra aplicaci�n este contenga todo lo que necesita para su ejecuci�n en su interior.

POM que significa y para que nos sirve
- El POM (Project Object Model) es un archivo en formato XML que contiene todo lo necesario para que a la hora de generar el fichero
ejecutable de nuestra aplicacion este contenga todo lo que necesita para su ejecucion en su interior.
Maven utiliza un Project Object Model (POM) para describir el proyecto de software a construir, sus dependencias de otros 
m�dulos y componentes externos, y el orden de construcci�n de los elementos. Viene con objetivos predefinidos para realizar 
ciertas tareas claramente definidas, como la compilaci�n del c�digo y su empaquetado.

Diferencia entre Archetype y Artifact
- Archetype es un patr�n o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo. 
Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnolog�as que los desarrolladores 
utilizan como base para escribir y organizar el c�digo de la aplicaci�n.
En cambio, Artifact no es ni m�s ni menos que un bloque de c�digo reutilizable, pero no es lo mismo que un jar, ya que este
es un bloque de codigo reutilizable pero ya compilado.  Normalmente la reutilizaci�n esta fuertemente ligada con la modularidad. 
Es decir a bloques de c�digo m�s peque�os mayor es la posibilidad de reutilizaci�n.

Explique los siguientes goals de Maven: [Clean, Package, Install, Compile]
- Un Goal no es mas que un comando que recibe maven como par�metro para que haga algo.
mvn clean: limpia todas las clases compiladas del proyecto.
mvn compile: compila el proyecto
mvn package: empaqueta el proyecto (si es un proyecto java simple, genera un jar, si es un proyecto web, un war, etc�)
mvn install: instala el artefacto en el repositorio local (/Users/home/.m2)

Explique los siguientes Scopes [Compile, Provider, Runtime, Test, System]
- El scope sirve para indicar el alcance de nuestra dependencia y su transitividad.
- compile: es la que tenemos por defecto sino especificamos scope. Indica que la dependencia es necesaria para compilar. 
 La dependencia adem�s se propaga en los proyectos dependientes.
- provided: Es como la anterior, pero esperas que el contenedor ya tenga esa libreria. Un claro ejemplo es cuando desplegamos en un servidor de 
aplicaciones, que por defecto, tiene bastantes librer�as que utilizaremos en el proyecto, as� que no necesitamos desplegar la dependencia.
- runtime: La dependencia es necesaria en tiempo de ejecuci�n pero no es necesaria para compilar.
- test: La dependencia es solo para testing que es una de las fases de compilaci�n con maven. JUnit es un claro ejemplo de esto.
- system: Es como provided pero tienes que incluir la dependencia explicitamente. Maven no buscar� este artefacto en tu repositorio local. 
Habr� que especificar la ruta de la dependencia mediante la etiqueta <systemPath>