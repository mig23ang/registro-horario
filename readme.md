## software para el registro de horas de entrada y salida de trabajadores

# comnando de ejecucion

```sh

mvn spring-boot:run 

mvn install
```





mvn clean install generate-sources

## COMANDO PARA GENERAR LA BASE DE DATOS POSTGREES CONDOCKER
```sh
docker run --name postgres-horas -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin123 -e POSTGRES_DB=empresa -p 5432:5432 postgres
```
## comando para resetar cambios con conflictos



## script para crear ramas y subor al remoto
```sh
git checkout -b nombre-rama # crear rama
git checkout nombre-rama # cambiar a la rama
git branch # ver ramas
git merge --reset  # abortar merge


git reset --hard "Poner commit" # resetear cambios a un commit especifico

```

tarea: nivelar las ramas de cada uno con la develop
