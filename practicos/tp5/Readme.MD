# Práctico 5 - Servidor imagenes vectoriales

El practico consiste en tomar el 
practico 4 y añadir la funcionalidad
de servidor.

El programa dibuja en linea los 
comandos que se le envia desde un
cliente de red (putty).

## Protocolo

El protocolo define los mensajes que
nuestro servidor debe poder reconocer.

EN este caso, el servidor debe 
reconocer 5 mensajes.

1. Autenticacion en la aplicacion

Si bien no podemos crear toda una
estrategia de autenticacion podemos
pedirle una clave para poder iniciar
sesion.

El primer mensaje que el cliente debe
enviar cuando se conecta es:
````
LOGIN bolivia2025
````
El comando es LOGIN y el parametro es 
bolivia2025. Si el usuario coloca
otro parametro entonces se desconecta
el socket.

La respuesta del servidor cuando la
clave es correcta es OK.

2. Crear una linea

EL formato del mensaje para crear
una linea es el siguiente:
````
LINEA 245 378 390 280 verde
````
Los parametros son:
* x1, y1: punto de inicio
* x2, y2: punto final
* color: texto indicando color (verde, azul, rojo, negro)

Si los parametros estan correctos
entonces el servidor devuelve OK.
Si los parametros no estan correctos
la respuesta del servidor es ERROR.

3. Crear un circulo

EL formato del mensaje para crear
un circulo es el siguiente:
````
CIRCULO 245 378 390 verde
````
Los parametros son:
* x1, y1: punto superior izquierdo
* diametro: es el ancho y el alto del circulo
* color: texto indicando color (verde, azul, rojo, negro)

Si los parametros estan correctos
entonces el servidor devuelve OK.
Si los parametros no estan correctos
la respuesta del servidor es ERROR.

4. Crear un rectangulo

EL formato del mensaje para crear
una linea es el siguiente:
````
RECTANGULO 245 378 390 280 verde
````
Los parametros son:
* x1, y1: punto de inicio
* ancho: el ancho del rectangulo
* alto: el alto del rectangulo
* color: texto indicando color (verde, azul, rojo, negro)

Si los parametros estan correctos
entonces el servidor devuelve OK.
Si los parametros no estan correctos
la respuesta del servidor es ERROR.

5. Fin de sesion

El usuario puede elegir desconectarse
a traves de un mensaje

````
FIN
````

## Mensaje desconocido

Si el usuario coloca cualquier mensaje que
el programa NO conoce, entonces se debe
devolver ERROR. PEro no se desconecta el
socket.

## Dibujar con chatgpt

Enseñarle a ChatGPT como se puede dibujar 
con los 3 comandos. Luego, pedirle que 
nos envie la lista de comandos necesaria
para dibujar una imagen compleja. Por
ejemplo: Mandela, Einstein, Che Guevara, etc.

## Presentación

El práctico debe ser presentado el 
31 de octubre de 2025
