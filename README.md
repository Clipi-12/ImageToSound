# ImageToSound

Un traductor de imágenes a audio.



# Requisitos

-Tener Windows o un sistema operativo basado en Linux.

-Tener instalado Java8 (en el caso de que queramos abrir la aplicación con el programa para Windows_64_bits).



# ¿Cómo descargar el proyecto?
Para descargar los programas solo hay descomprimir [este archivo](https://github.com/Clipi-12/ImageToSound/archive/master.zip "Archivo .zip que contiene el proyecto") (205 MB) en una carpeta (con cualquier nombre).

Si piensas que el archivo podría ser potencialmente un virus (lo cual deberías de pensar teniendo en cuenta que estás en internet y lo más probalbe es que no te hayas leído el código o no sepas de programación) te recuerdo que siempre puedes usar tu antivirus de confianza para analizarlo, o incluso [VirusTotal](https://virustotal.com), mi recomendación personal para analizar archivos y URLs de manera gratuita (sé que lo parece, pero no, no estoy patrocinado por ellos).



# ¿Cómo usar los programas?

Es muy sencillo, solo hace falta una imagen JPG\* de 1024 por 1024 píxeles o menos.

Esta imagen necesita llamarse "input.jpg" (sin las comillas, claro) y estar situada en la carpeta "Imagen_A_Sonido".

Una vez la imagen está colocada en la carpeta, solo hace falta abrir el programa que corresponda con tu sistema operativo (Imagen_A_Sonido => Ejecutables--Programas) o abrir el código con Processing (Imagen_A_Sonido => Processing--Codigo), lo que te da más versatilidad, aunque no es necesario.

Una vez el programa se está ejecutando puedes elegir a la velocidad a la que procesa la imagen y el audio moviendo el ratón de izquierda a derecha en la pantalla (si el ratón está a la izquierda de la pantalla, el programa se ejecutará de manera más "visual", pero si el ratón está a la derecha de la pantalla, el programa se ejecutará más rápido).


\* *Si quieres convertir una imagen png a jpg con otro programa tienes que tener en cuenta que el fondo tiene que ser de color negro.*



# Reusar sonidos

Cuando ejecutas el programa, la imágen se va a "traducir" a un sonido, pero tarda bastante. Por eso mismo existe un archivo llamado "data.json" que se crea (o modifica) cada vez que se usa el programa principal (ImageToSound) en la carpeta "data.json_A_Sonido".

Esto permite que puedas volver a escuchar el sonido que ha producido la imagen que has "traducido" sin tener que volver que ejecutar el otro programa (que puede llegar a ser lento en algunas ocasiones).

Para ejecutar este programa "secundario" y poder escuchar lo que el otro programa ha guardado en el archivo "data.json" solo tienes que abrir el programa que corresponda a tu sistema operativo (data.json_A_Sonido => Ejecutables--Programas) de la misma manera que la otra vez (o con Processing en data.json_A_Sonido => Processing--Codigo).



# Errores / Problemas / Los programas se cierran automáticamente

Los programas están programados para cerrarse si los archivos necesarios no existen, por lo que si ves que el programa se ha cerrado (o no se ha abierto) asegúrate de que la imagen "input.jpg" existe y no se ha corrompido (para el programa ImageToSound) y que el archivo "data.json" tampoco tenga problemas (para el programa secundario JSONToSound).

Además, el programa JSONToSound (el "secundario", con el qe se puede reproducir el contenido de "data.json") se cerrará automáticamente si la resolución del sonido se ha cambiado en el primer pero no en el secundario (únicamente ocurre si se ha modificado el código manualmente, es decir, usando Processing, no los archivos ejecutables).

Si existen otros problemas o errores (que el programa se quede congelado, por ejemplo), contactame en Twitter ([@\_Clipi\_](https://twitter.com/_Clipi_)) con información como el país del que eres (o mejor dicho, el país con el que tienes configurado el ordenador), el tamaño de la imagen, etc.
