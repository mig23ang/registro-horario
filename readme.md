# Software para el registro de horas de entrada y salida de trabajadores

# comando de ejecucion

```sh

mvn install

mvn spring-boot:run 


```

mvn clean install generate-sources

## COMANDO PARA GENERAR LA BASE DE DATOS POSTGREES CON DOCKER
```sh
docker run --name postgres-horas -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin123 -e POSTGRES_DB=empresa -p 5432:5432 postgres
```
## comando para resetar cambios con conflictos



## script para crear ramas y subir al remoto
```sh
git checkout -b nombre-rama # crear rama
git checkout nombre-rama # cambiar a la rama
git branch # ver ramas
git merge --reset  # abortar merge


git reset --hard "Poner commit" # resetear cambios a un commit especifico

```

## Agregar Variables de entorno: Crear archivo .env y pegar:
(Comentar o descomentar segun la base de datos que se vaya a utilizar)
```
# Base de datos PostgreSQL
DATASOURCE_URL=jdbc:postgresql://localhost:5432/empresa
DATASOURCE_USERNAME=admin
DATASOURCE_PASSWORD=admin123

# Base de datos MySQL
# DATASOURCE_URL=jdbc:mysql://localhost:3306/empresa
# DATASOURCE_USERNAME=root
# DATASOURCE_PASSWORD=admin

```

