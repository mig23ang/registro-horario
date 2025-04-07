## Software para el registro de horas de entrada y salida de trabajadores

# Comando de ejecucion

```
mvn spring-boot:run 
```
```
mvn install
```
```
mvn clean install generate-sources
```

## COMANDO PARA GENERAR LA BASE DE DATOS MYSQL CON DOCKER

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin123 -e MYSQL_DATABASE=empresa -p 3307:3306 -d mysql:latest

## COMANDO PARA LIMPIAR DEPENDENCIAS

```
mvn clean install compile
```