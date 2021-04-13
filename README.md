# aos-ss3 [![Java CI/CD](https://github.com/zugazagoitia/aos-ss3/actions/workflows/main.yml/badge.svg)](https://github.com/zugazagoitia/aos-ss3/actions/workflows/main.yml) [![Publish Docker image](https://github.com/zugazagoitia/aos-ss3/actions/workflows/docker.yml/badge.svg)](https://github.com/zugazagoitia/aos-ss3/actions/workflows/docker.yml)

Subsistema de gestión de trabajos de un taller para la asignatura de AOS

## Instalación y uso

Es posible la ejecución del servidor de Spring a través de un goal de maven, pero se recomienda encarecidamente hacer
uso del archivo docker-compose.

Usa [docker](https://docs.docker.com/get-docker/) para instalar y ejecutar el servicio.

El código del repositorio no es necesario para su ejecución, únicamente el archivo `docker-compose.yml` disponible en
los [releases](https://github.com/zugazagoitia/aos-ss3/releases). Una vez descargado ejecutar sobre su directorio:

```bash
docker-compose up
```

De forma automática se configurará y ejecutará el servicio, disponible junto a su documentación en el puerto `8080`

## Automatización

Todos los commit son probados y compilados por la action `main.yml`.

Para cada release se compila y publica en docker hub una imagen con el servicio listo para ser usado. Este proceso se
define en la action `docker.yml`.