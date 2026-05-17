# Hexagonal Template (Demo)

Plantilla de microservicio Java con arquitectura hexagonal (Spring Boot, JPA, MySQL)
Contiene una plantilla de microservicio basada en Spring Boot que sigue principios hexagonales (ports & adapters).

## Resumen

Es una aplicación de ejemplo para la gestión de pagos con una capa de dominio, casos de uso (ports), adaptadores de entrada (API REST) y adaptadores de salida (persistencia). Está pensada como punto de partida para construir microservicios siguiendo la arquitectura hexagonal.

## Requisitos

- JDK 17
- Maven (puedes usar el wrapper incluido `./mvnw` o `mvn` instalado globalmente)
- MySQL (la configuración por defecto usa una base de datos llamada `payment_management`)

Las dependencias principales están en `pom.xml` (Spring Boot 3.2.1, Spring Web, Spring Data JPA, MySQL connector, Lombok, etc.).

## Configuración

Archivo de propiedades: `src/main/resources/application.properties`

Propiedades relevantes por defecto:

- `spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/payment_management` (usa la variable de entorno `MYSQL_HOST` si está definida)
- `spring.datasource.username=root`
- `spring.datasource.password=123456`
- `spring.jpa.hibernate.ddl-auto=update`

Nota: cambia estas propiedades para tu entorno (usuario/contraseña/host). Para producción no uses credenciales en texto plano.

## Cómo compilar y ejecutar

1. Construir el JAR:

```bash
./mvnw -v   # opcional: verificar Maven
./mvnw clean package
```

2. Ejecutar con Maven (modo desarrollo):

```bash
./mvnw spring-boot:run
```

3. Ejecutar el JAR generado:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

4. Ejecutar tests:

```bash
./mvnw test
```

En Windows (PowerShell o CMD) usa `mvnw.cmd` en lugar de `./mvnw` si prefieres.

## Endpoints (ejemplos)

La implementación REST expone controladores bajo el prefijo `payment_management`.

- GET /payment_management/payment
  - Devuelve todos los pagos (200 + payload) o 204 si no hay contenido.

- POST /payment_management/payment
  - Crea un pago. Body JSON esperado (según `PaymentRequestDTO`):

```json
{
  "idTransaction": "abc-123",
  "nombre": "Juan Perez",
  "monto": 123.45
}
```

Ejemplo con curl:

```bash
curl -X POST "http://localhost:8080/payment_management/payment" \
  -H "Content-Type: application/json" \
  -d '{"idTransaction":"abc-123","nombre":"Juan","monto":10.5}'
```

## Estructura de carpetas

Resumen de la estructura principal y propósito de cada paquete (ruta basada en `src/main/java`):

- `com.poc.microservice.demo` — paquete raíz
  - `DemoApplication.java` — clase principal Spring Boot
  - `configuration` — `BeansConfiguration.java` para definir beans/common wiring
  - `adapters` — adaptadores (entrada/salida)
    - `in` — adaptadores de entrada (API REST)
      - `api`
        - `rest`
          - `commons` — clases compartidas para la API (por ejemplo `CustomResponse`)
          - `controllers` — controladores REST
            - `payment` — `PaymentController`, `PaymentControllerImpl`, `BaseController`
          - `dtos` — DTOs de entrada/salida (`PaymentRequestDTO`)
          - `mappers` — mapeadores DTO <-> dominio (`PaymentMapper`, `PaymentMapperImpl`)
  - `application` — lógica de aplicación (casos de uso / puertos)
    - `exceptions` — excepciones de la capa de aplicación
    - `ports` — interfaces (in/out) que definen los casos de uso y puertos externos
      - `in` — puertos de entrada (use cases) como `PaymentGetAllUseCase`, `PaymentSaveUseCase`
      - `out` — puertos de salida (persistencia) — implementaciones en adaptadores de salida (no mostradas aquí)
    - `service` — implementaciones de casos de uso (por ejemplo `PaymentService`)
  - `domain` — entidades de dominio
    - `base` — clases base del dominio (por ejemplo `Domain`)
    - `payment` — entidad `Payment`
