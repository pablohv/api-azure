# API Rest en SpringBoot desplegada en Azure

## Este es una API Rest desplegada en Azure, se utilizaron los siguientes recursos:

<ul>
  <li>App Services</li>
  <li>Azure Database for MySQL</li>
</ul>

## La API es un CRUD de clientes y tiene patron de diseño MCV + Dao + Dto + JPA

A continuacion se ponen los pasos para lograr el despliegue:

1. El primer paso es seleccionar un recurso para la base de datos en MySQL y lo creamos con las especificaciones que deseemos 

![1](https://user-images.githubusercontent.com/58754667/120941760-23311c00-c6ea-11eb-8548-53a768fe9092.PNG)

2. Damos acceso al firewall de la BD para conectarnos remotamente
****** es importante que en tu base de datos des acceso a todas las ip de lo contrario no te dejará correr el proyecto

![2](https://user-images.githubusercontent.com/58754667/120941770-2cba8400-c6ea-11eb-85a6-099d28f48fc6.PNG)

3. Tomamos los valores de conexión para conectarnos remotamente 

![3](https://user-images.githubusercontent.com/58754667/120941797-5d9ab900-c6ea-11eb-8ddd-866a642cdcb9.PNG)

4. Seleccionamos la que dice jdbc y nos conectamos con Workbench

![4](https://user-images.githubusercontent.com/58754667/120941803-63909a00-c6ea-11eb-88e9-f3cf57cda3c4.PNG)

5. Creamos la base de datos a la que se conectara nuestra API
6. Desplegamos nuestra aplicación en local para ver que la conexión sea válida y generará la tabla

![5](https://user-images.githubusercontent.com/58754667/120941813-74411000-c6ea-11eb-80bc-308d14505464.PNG)

7. Creamos ahora un app service, seleccionamos SE ya que se utilizara el tomcat embebido que tiene Spring

![6](https://user-images.githubusercontent.com/58754667/120941821-8a4ed080-c6ea-11eb-8184-b50eafd4d011.PNG)

8. Una vez que tengamos creemos la instancia de app service vamos al recurso y damos click al deploy center para conectarnos con github y seleccionar nuestro proyecto, la rama y despues guardamos, una vez hecho esto en nuestro pproyecto en git aparecera una carpeta nueva llamada workflow

![7](https://user-images.githubusercontent.com/58754667/120941826-92a70b80-c6ea-11eb-99db-1fc328b9a7f6.PNG)

9. Una vez que termina el workflow te aparecera que se ha desplegado correctamente el proyecto

![8](https://user-images.githubusercontent.com/58754667/120941829-9a66b000-c6ea-11eb-9d6c-9b4c2de5f500.PNG)

10. Ahora tienes que ir al portal de azure y seleccionas introduccion y das click en la URL

![9](https://user-images.githubusercontent.com/58754667/120941841-a9e5f900-c6ea-11eb-8b07-63d8f4c494d2.PNG)

11. En mi caso me aparece un error por que no tengo nada en la raiz del proyecto

![10](https://user-images.githubusercontent.com/58754667/120941850-b0747080-c6ea-11eb-92fa-d5729a67aba5.PNG)

12. Como tengo swagger podemos ver las acciones que tenemos en la api en este caso es un CRUD

![11](https://user-images.githubusercontent.com/58754667/120941853-b5392480-c6ea-11eb-8468-07233a79657b.PNG)

13. Ahora toca testea, en mi caso utilizare postman empezaremos haciendo un cliente, no se debe de especificar el ID ya que es autoincrementable

![12](https://user-images.githubusercontent.com/58754667/120941856-b9fdd880-c6ea-11eb-8ccd-b4341088b7eb.PNG)

14. Actualizamos el registro

![13](https://user-images.githubusercontent.com/58754667/120941861-c1bd7d00-c6ea-11eb-8e9f-a09dbcf82cea.PNG)

