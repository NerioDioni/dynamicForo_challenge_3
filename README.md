# Api rest:DynamicForo
![login](https://github.com/user-attachments/assets/3a7425da-0e48-4a9e-8a7a-7aa73502a38c)

_Proyecto que dasarrolla una api rest en lenguaje java como parte del challenge 3 del curso desarrollador Backend del programa de estudio Oracle one next education junto con AluraLatam_

## Comenzando 🚀

_Es un aplicacion basada en la idea de manejar los topicos de un foro y es esclusivamante en el caso de uso en el que nos centraremos_


### Pre-requisitos 📋

_java JDK: versión 17 en adelante - 
Descarga la última versión LTS de Java gratuita_

MySQL: versión 8 en adelante *- MySQL :: Download MySQL Installer (Instalador para Windows)

IDE (Entorno de desarrollo integrado) IntelliJ IDEA - opcional -


+Contar una base datos ya creada en  MYSQL _



### Instalación 🔧
_Ingresar las configuraciones de las variables correspondiente en el archivo:_
```
AplicationProperties
```
_*Ya hecha la coneccion con la base y correr la aplicacion se procederan a crear las tablas necesarias para el uso de la Api_


## Ejecutando las pruebas ⚙️

_Para la ejecucion y simulacion de los diferestes casos de uso se usara Insomnia el cual nos ayudara a crear las request necesarias con los metodos adecuados par las pruebas_

_Cabe destacar que se asume que para este punto la base de datos en las Tablas *usuarios y *cursos ya cuenta con datos y solo se procedera a la manipulacion de datos para la entidad TOPICO_

### Login

_Se deben de enviar en formato json los datos necesarios para generar el token de autenticacion que nos servira para validar la ejecucion de las demas fucioncioes_

```
https://raw.githubusercontent.com/NerioDioni/dynamicForo_challenge_3/main/login.png
![login](https://github.com/user-attachments/assets/910ea898-55cd-48d8-bcd1-25f30f5c9059)

```
### Ingreso de topicos
_Se deben de enviar en formato json los datos necesarios para generar la insercion de dicho registro_

No olvidar ingresar el token typo Bearer_token generado cuando se logeo en apartado Auth de de insomnia _
```
![put](https://github.com/user-attachments/assets/e3a6a272-3c8b-426f-88b4-e3469e7fb034)

```
### Consulta de lista de topicos
_enviar peticion get para obtener una lista de los topicos con su descripcion._

_No olvidar ingresar el token typo Bearer_token generado cuando se logeo en apartado Auth de de insomnia _
```
![getLista](https://github.com/user-attachments/assets/7d94aede-5d71-494c-8a7d-924ca78c8857)

```
### Consulta de topico
_enviar peticion get  y un id en la url para obtener un topico con su descripcion._

_No olvidar ingresar el token typo Bearer_token generado cuando se logeo en apartado Auth de de insomnia _
```
![update1](https://github.com/user-attachments/assets/6864d0e4-0de4-4b91-9528-e92f37d67e8b)

```

### Actualizar un topico
_enviar peticion junto con el id del topico a modificar , puede consultar la lista de topicos ingresados para saber el id del que desea modificar._

_No olvidar ingresar el token typo Bearer_token generado cuando se logeo en apartado Auth de de insomnia _
```
![update2](https://github.com/user-attachments/assets/1cf4df44-5000-445e-b23f-61d19f1fcb6f)

```
### Desactivar/cerrar topico
_enviar peticion junto con el id del topico a desactivar o cerrar, puede consultar la lista de topicos ingresados para saber el id del que desea modificar._

_No olvidar ingresar el token typo Bearer_token generado cuando se logeo en apartado Auth de de insomnia _
```
![delete2](https://github.com/user-attachments/assets/b84c5d28-322c-475e-99c2-3a0bc9de4d69)

```
