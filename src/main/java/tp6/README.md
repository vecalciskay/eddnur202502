# Planificacion TP6

Clase abstracta Figura
Nombre, Identificador, Color, X, Y, ancho, alto
Clase concretas: Cuadrado, Circulo

Toda figura debe saber dibujarse.
Toda figura debe poder decir si un punto
x,y esta dentro o no de la figura.
Toda figura debe saber si el clic fue en la
parte de abajo o en la parte de arriba.

Todo debe estar en un arbol. Entonces mi
objeto principal es:
Arbol<Figura> modelo

El panel es un observador de modelo.
El modelo (o sea el arbol) debe poder ser
observado

Los objetos necesitan un identificador.
Se puede crear una variable de clase que 
tiene el proximo ID que se debe colocar en 
la figura.

Si no existe el metodo de eliminar en el 
arbol, entonces hay que desarrollarlo.

PAra dibujar el arbol, se puede crear un
objeto especializado en dibujar 
ArbolObservable<Figura>. DE esta manera no
contaminamos el modelo ArbolObservable.