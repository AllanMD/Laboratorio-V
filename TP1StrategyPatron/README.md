Que es Maven
- Maven es una herramienta cuyo objetivo es simplificar los procesos de build (compilar y generar ejecutables a partir del código fuente).
Posee la capacidad de realizar ciertas tareas claramente definidas, como la compilación del código y su empaquetado. 
Es decir, hace posible la creación de software con dependencias incluidas dentro de la estructura del JAR. 
Es necesario definir todas las dependencias del proyecto (librerías externas utilizadas) en un fichero propio de todo proyecto Maven,
el POM (Project Object Model). Este es un archivo en formato XML que contiene todo lo necesario para que a la hora de generar el fichero 
ejecutable de nuestra aplicación este contenga todo lo que necesita para su ejecución en su interior.

POM que significa y para que nos sirve
- El POM (Project Object Model) es un archivo en formato XML que contiene todo lo necesario para que a la hora de generar el fichero
ejecutable de nuestra aplicacion este contenga todo lo que necesita para su ejecucion en su interior.
Maven utiliza un Project Object Model (POM) para describir el proyecto de software a construir, sus dependencias de otros 
módulos y componentes externos, y el orden de construcción de los elementos. Viene con objetivos predefinidos para realizar 
ciertas tareas claramente definidas, como la compilación del código y su empaquetado.

Diferencia entre Archetype y Artifact
- Archetype es un patrón o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo. 
Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías que los desarrolladores 
utilizan como base para escribir y organizar el código de la aplicación.
En cambio, Artifact no es ni más ni menos que un bloque de código reutilizable, pero no es lo mismo que un jar, ya que este
es un bloque de codigo reutilizable pero ya compilado.  Normalmente la reutilización esta fuertemente ligada con la modularidad. 
Es decir a bloques de código más pequeños mayor es la posibilidad de reutilización.

Explique los siguientes goals de Maven: [Clean, Package, Install, Compile]
- Un Goal no es mas que un comando que recibe maven como parámetro para que haga algo.
mvn clean: limpia todas las clases compiladas del proyecto.
mvn compile: compila el proyecto
mvn package: empaqueta el proyecto (si es un proyecto java simple, genera un jar, si es un proyecto web, un war, etc…)
mvn install: instala el artefacto en el repositorio local (/Users/home/.m2)

Explique los siguientes Scopes [Compile, Provider, Runtime, Test, System]
- El scope sirve para indicar el alcance de nuestra dependencia y su transitividad.
- compile: es la que tenemos por defecto sino especificamos scope. Indica que la dependencia es necesaria para compilar. 
 La dependencia además se propaga en los proyectos dependientes.
- provided: Es como la anterior, pero esperas que el contenedor ya tenga esa libreria. Un claro ejemplo es cuando desplegamos en un servidor de 
aplicaciones, que por defecto, tiene bastantes librerías que utilizaremos en el proyecto, así que no necesitamos desplegar la dependencia.
- runtime: La dependencia es necesaria en tiempo de ejecución pero no es necesaria para compilar.
- test: La dependencia es solo para testing que es una de las fases de compilación con maven. JUnit es un claro ejemplo de esto.
- system: Es como provided pero tienes que incluir la dependencia explicitamente. Maven no buscará este artefacto en tu repositorio local. 
Habrá que especificar la ruta de la dependencia mediante la etiqueta <systemPath>