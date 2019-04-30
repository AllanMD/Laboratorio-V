# TP 2 Threads

### Diferencia entre Runnable y Thread
Las principales diferencias son:  
- Si extendemos de la clase Thread, perdemos la oportunidad de poder extender de otra clase, ya que Java no admite herencia multiple. En cambio, si se implementa la interfaz Runnable, si se puede extender de otra clase.

- En Thread, cada hilo crea un unico objeto y se asocia con el, mientras que en Runnable todos los hilos comparten el mismo objeto

- En Thread al crearse un unico objeto para cada hilo, se utiliza mas memoria, en cambio con Runnable se utiliza menos ya que todos los hilos comparten el mismo objeto.

- Si solo necesitamos del metodo run(), la mejor opcion podria ser implementar Runnable, ya que si extendemos de Thread, heredamos todos sus metodos y podriamos no necesitarlos, en cambio si implementamos Runnable, solo tendremos que sobreescribir el metodo run().
___
## Ciclo de vida de un Thread.

Un thread puede presentar cuatro estados distintos:

1. Nuevo (New): El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el método start(). Se producirá un mensaje de error (IllegalThreadStateException) si se intenta ejecutar cualquier método de la clase Thread distinto de start().

2. Ejecutable (Runnable): El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU. En la práctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

3. Bloqueado (Blocked o Not Runnable): El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide, como por ejemplo una espera producida por una operación de escritura o lectura de datos por teclado (E/S). Si un thread está en este estado, no se le asigna tiempo de CPU.

4. Muerto (Dead): La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de la clase Thread, aunque dicho método es considerado “peligroso” y no se debe utilizar.

___
### Explique los siguientes metodos: [start, sleep, yield, join]

- start(): Inicializa el thread y hace que ejecute lo que esta dentro del metodo run()
- sleep(): Le dice al thread que duerma durante los milisegundos específicados. De esta forma pausamos por determinado tiempo un thread, y atrasamos su ejecucion. sleep() no consume recursos del sistema mientras el thread duerme.
- yield(): Mueve al thread que se esta ejecutando al final de la cola de procesos en espera por la CPU, para permitir la ejecucion de otros hilos (regresa al estado "listo para ejecutar").
- join(): Para indicar a un thread que debe esperar a que el hilo en ejecucion termine para poder empezar.