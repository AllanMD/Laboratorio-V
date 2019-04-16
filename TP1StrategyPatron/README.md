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

diferencia entre Archetype y ArtifacId
- Archetype es un patrón o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo. 
Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías que los desarrolladores 
utilizan como base para escribir y organizar el código de la aplicación.