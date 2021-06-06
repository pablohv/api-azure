# API Rest en SpringBoot desplegada en Azure

##Este es una API Rest desplegada en Azure, se utilizaron los siguientes recursos:

<ul>
  <li>App Services</li>
  <li>Azure Database for MySQL</li>
</ul>

##La API es un CRUD de clientes 

A continuacion se ponen los pasos para lograr el despliegue:

1. El primer paso es seleccionar un recurso para la base de datos en MySQL y lo creamos con las especificaciones que deseemos 



2. Damos acceso al firewall de la BD para conectarnos remotamente

3. Tomamos los valores de conexión para conectarnos remotamente 

4. Seleccionamos la que dice jdbc y nos conectamos con Workbench

5. Creamos la base de datos a la que se conectara nuestra API
6. Desplegamos nuestra aplicación en local para ver que la conexión sea válida y generará la tabla
7. Creamos ahora un app service, seleccionamos SE ya que se utilizara el tomcat embebido que tiene Spring
8. Una vez que tengamos creemos la instancia de app service vamos al recurso y damos click al deploy center para conectarnos con github y seleccionar nuestro proyecto, la rama y despues guardamos, una vez hecho esto en nuestro pproyecto en git aparecera una carpeta nueva llamada workflow
****** es importante que en tu base de datos des acceso a todas las ip de lo contrario no te dejará correr el proyecto

9. Una vez que termina el workflow te aparecera que se ha desplegado correctamente el proyecto
10. Ahora tienes que ir al portal de azure y seleccionas introduccion y das click en la URL
11. En mi caso me aparece un error por que no tengo nada en la raiz del proyecto
12. Como tengo swagger podemos ver las acciones que tenemos en la api en este caso es un CRUD 
13. Ahora toca testea, en mi caso utilizare postman empezaremos haciendo un cliente, no se debe de especificar el ID ya que es autoincrementable
14. Actualizamos el registro
