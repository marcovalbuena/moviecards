# Documentación del Trabajo Final - Integración Continua
**Alumno:** Marco Valbuena

## 1. Arquitectura del Proyecto
Se ha realizado una migración de una arquitectura monolítica a una basada en microservicios.
- **Frontend:** Aplicación web desplegada en Azure que consume la API del servicio.
- **Backend (Service):** Servicio independiente que gestiona la persistencia de datos en una base de datos propia.

## 2. URLs de Despliegue
- **Producción:** https://moviecards-valbuenab.azurewebsites.net 
- **Pre-producción (Stage):** https://moviecards-pre-valbuenab.azurewebsites.net
- **Servicio API:** https://moviecards-service-valbuenab.azurewebsites.net 

## 3. Implementación de deadDate
Se ha añadido el atributo `deadDate` (fecha de fallecimiento) en la clase `Actor` de ambos repositorios.
- Se actualizó el formulario de creación de actores.
- Se añadió una columna en el listado para visualizar la fecha.

## 4. Pipeline de CI/CD
El workflow implementado en GitHub Actions realiza los siguientes trabajos:
1. **Build & QA:** Compilación con Maven y análisis estático con SonarCloud.
2. **Stage:** Despliegue automático en el entorno de pre-producción.
3. **Deploy:** Despliegue en el entorno de producción final tras superar las etapas anteriores.