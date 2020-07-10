# ImageToSound

Un traductor de imágenes a audio.



# Requisitos

-Tener Windows o un sistema operativo basado en Linux.
-El único requisito es tener instalado Java8 (en el caso de que queramos abrir la aplicación con el programa para Windows_64_bits).



# ¿Cómo funciona?

Es muy sencillo, solo hace falta una imagen JPG\* de 1024 por 1024 píxeles o menos.

Esta imagen necesita llamarse "input.jpg" (sin las comillas, claro) y estar situada en la carpeta "Imagen_A_Sonido".

Una vez la imagen está colocada en la carpeta, solo hace falta abrir el programa que corresponda con tu sistema operativo (Imagen_A_Sonido => Ejecutables--Programas) o abrir el código con Processing (Imagen_A_Sonido => Processing--Codigo), lo que te da más versatilidad, aunque no es necesario.

Una vez el programa se está ejecutando puedes elegir a la velocidad a la que procesa la imagen y el audio moviendo el ratón de izquierda a derecha en la pantalla (si el ratón está a la izquierda de la pantalla, el programa se ejecutará de manera más "visual", pero si el ratón está a la derecha de la pantalla, el programa se ejecutará más rápido).


\* *Si quieres convertir una imagen png a jpg con otro programa tienes que tener en cuenta que el fondo tiene que ser de color negro.*



# Reusar sonidos

Cuando ejecutas el programa, la imágen se va a "traducir" a un sonido, pero tarda bastante. Por eso mismo existe un archivo llamado "data.json" que se crea (o modifica) cada vez que se usa el programa principal (ImageToSound) en la carpeta "data.json_A_Sonido".

Esto permite que puedas volver a escuchar el sonido que ha producido la imagen que has "traducido" sin tener que volver que ejecutar el otro programa (que puede llegar a ser lento en algunas ocasiones).

Para ejecutar este programa "secundario" y poder escuchar lo que el otro programa ha guardado en el archivo "data.json" solo tienes que abrir el programa que corresponda a tu sistema operativo (data.json_A_Sonido => Ejecutables--Programas) de la misma manera que la otra vez (o con Processing en data.json_A_Sonido => Processing--Codigo).
