## software para el registro de horas de entrada y salida de trabajadores

# comnando de ejecucion

```sh
mvn install

mvn spring-boot:run 


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




🎯 Objetivo
El objetivo de esta prueba es poner en práctica los conceptos trabajados durante la semana: control de versiones con Git, validación de datos en entidades y manejo global de excepciones en una API Spring Boot.

📋 Instrucciones
✅ 1. Control de versiones con Git
Asegúrate de tener tu repositorio actualizado con la rama remota develop.

Desde tu terminal, estando en tu rama personal (ej: nombre.apellido), ejecuta:

bash
Copy
Edit
git checkout develop
git pull origin develop
git checkout nombre.apellido
git merge develop
Resuelve posibles conflictos, valida que el proyecto compile y sube los cambios a tu rama:

bash
Copy
Edit
git add .
git commit -m "merge de develop a mi rama"
git push origin nombre.apellido
✅ 2. Capa de validación (@Valid)
Modifica tu entidad principal (por ejemplo: UsuarioEntity) e implementa validaciones con anotaciones como:

@NotBlank

@Email

@Size

@NotNull

📌 Ejemplo:

java
Copy
Edit
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
Asegúrate de aplicar al menos tres tipos diferentes de validación.

✅ 3. Manejo global de excepciones
Agrega o ajusta una clase @ControllerAdvice para capturar errores de validación y retornar mensajes personalizados al cliente.

📌 Requisitos:

Capturar MethodArgumentNotValidException y retornar un Map<String, String> con campo y mensaje.

Capturar al menos una excepción personalizada, por ejemplo UsuarioNoEncontradoException, y retornar un mensaje claro y código HTTP apropiado (404, 400, etc).

📦 Entrega
Sube tu código a tu rama personal.

Sube un video corto (puede ser grabación de pantalla) mostrando:

Ejecución de la API con datos inválidos (para que se vean los mensajes de validación)

Una prueba de una excepción personalizada

El video debe cargarse a Teams en la carpeta correspondiente a tu grupo.

🏁 Criterios de evaluación (20 puntos)
Ítem	Puntaje
Uso correcto de Git y merge desde develop	5 pts
Validaciones implementadas correctamente	7 pts
Manejador global de excepciones funcional	5 pts
Video explicativo claro y completo	3 pts