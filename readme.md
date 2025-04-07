## software para el registro de horas de entrada y salida de trabajadores

# comnando de ejecucion

```sh

mvn spring-boot:run 

mvn install
```

 



mvn clean install generate-sources

## COMANDO PARA GENERAR LA BASE DE DATOS POSTGREES CONDOCKER

docker run --name postgres-horas -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin123 -e POSTGRES_DB=empresa -p 5432:5432 postgres

## comando para resetar cambios con conflictos

```sh
git merge --reset   


git reset --hard ac35ccb10685263f41ccf1309c972cb6e7be45ea
```