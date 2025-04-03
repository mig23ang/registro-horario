## software para el registro de horas de entrada y salida de trabajadores

# comnando de ejecucion

```sh

mvn spring-boot:run 

mvn install
```

 



mvn clean install generate-sources

## COMANDO PARA GENERAR LA BASE DE DATOS POSTGREES CONDOCKER

docker run --name postgres-horas -e POSTGRES_USER=admin -e POSTGRES_USER=admin123 -e POSTGRES_DB=empresa -p 5432:5432 postgres