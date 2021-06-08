# aos-ss3 [![Java CI/CD](https://github.com/zugazagoitia/aos-ss3/actions/workflows/main.yml/badge.svg)](https://github.com/zugazagoitia/aos-ss3/actions/workflows/main.yml) [![Publish Docker image](https://github.com/zugazagoitia/aos-ss3/actions/workflows/docker.yml/badge.svg)](https://github.com/zugazagoitia/aos-ss3/actions/workflows/docker.yml) [![Docker Image Size (tag)](https://img.shields.io/docker/image-size/albertozuga/aos-ss3/latest)](https://hub.docker.com/r/albertozuga/aos-ss3)

Subsistema de gestión de trabajos de un taller para la asignatura de AOS

## Instalación y uso

> :warning: **Actualmente solo permite el intercambio de información en formato json**: Si la cabecera _Accept_ no contiene `application/json` el api devolverá un error, está pendiente de implementación de XML en algunos endpoints.

Es posible la ejecución del servidor de Spring a través de un goal de maven, pero se recomienda encarecidamente hacer
uso del archivo docker-compose.

Usa [docker](https://docs.docker.com/get-docker/) para instalar y ejecutar el servicio.

El código del repositorio no es necesario para su ejecución, únicamente el archivo `docker-compose.yml` disponible en
los [releases](https://github.com/zugazagoitia/aos-ss3/releases). Una vez descargado ejecutar sobre su directorio:

```bash
docker-compose up
```

De forma automática se configurará y ejecutará el servicio http, disponible junto a su documentación en el puerto `8080`

## Implementación

La imagen de este servicio se puede encontrar en [Docker Hub](https://hub.docker.com/r/albertozuga/aos-ss3)

De cara a implementar el servicio en un cluster de kubernetes se puede tomar como referencia la especificación del archivo `docker-compose.yml` de este repositorio. En el se detalla la implementación, y los parámetros requeridos por el contenedor de persistencia (MariaDB). En caso de querer realizar una base de datos distribuida se puede usar [MariaDB Galera](https://hub.kubeapps.com/charts/bitnami/mariadb-galera)

## Automatización

Todos los commit son probados y compilados por la action `main.yml`.

Para cada release se compila y publica en docker hub una imagen con el servicio listo para ser usado. Este proceso se
define en la action `docker.yml`.
