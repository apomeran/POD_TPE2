POD_TPE2
========

TPE2 - JGroups - Programacion Objetos Distribuidos


TP Adicional - JGROUPS
========
Ej 1
Descargar la última versión de JGroups de http://www.jgroups.org/ 
Crear un nuevo proyecto de java en Eclipse e importar la librería.
Crear una clase Ejercicio1 que permita conectarse y desconectarse de un cluster.
La clase debe crear un Channel al momento de instanciarse, poseer un método para conectarse al cluster (el nombre es parámetro) y otro para desconectarse.
La clase debe extender de ReceiveAdapter
Crear un programa de prueba que utilizando la clase anterior, se conecta al cluster y 5 segundos despues se desconecte.
========
Ej 2			
Crear una clase llamada Ejercicio02 que extienda de la clase Ejercicio01 y le agregue la posibilidad de detectar cuando un channel se conecta o desconecta del cluster en el que se encuentra. 
========
Ej 3				
Crear una clase llamada Ejercicio03 que extienda de la clase Ejercicio02 y le agregue la posibilidad de enviar un mensaje a un channel en particular en lugar de a todos los channels al mismo tiempo. 
Crear un programa de prueba en donde se envi´a un mensaje a cada uno de los channels conectados de manera individual. 
========
Ej 4				
Crear una clase llamada SimpleChat, la cual sirve para representar una sala de chat tradicional de internet. En la misma, lo usuarios se conectan, reciben las notificaciones de un nuevo usuario conectado y los mensajes que se envi´an son para todos los usuarios. 
========
Ej 5				
Agregar al ejercicio anterior la posibilidad de enviar un mensaje a un usuario en particular en lugar de hacerlo a todos los usuarios. Los mensajes en particular son distinguidos de los dema´s al agregar un #, el nombre del usuario y dos puntos. Por ejemplo: #usuario: 
