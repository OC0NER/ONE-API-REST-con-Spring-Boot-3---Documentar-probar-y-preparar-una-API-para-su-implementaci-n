# ONE-API-REST-con-Spring-Boot-3---Documentar-probar-y-preparar-una-API-para-su-implementaci-n

 ## 7️⃣ Séptimo curso de la formación Java y Spring Boot del grupo G6 del curso ONE - Oracle Next Education

## 🎯 Los objetivos del curso son: 

- [x] Aprender a aislar código de reglas de negocio en una aplicación
- [x] Implementar principios SOLID
- [x] Documentar una API siguiendo el estándar OpenAPI
- [x] Aprender a escribir pruebas automatizadas en una aplicación con Spring Boot
- [x] Usar variables de entorno y prepare una aplicación para su implementación

---

## Documentación de la API:

- Aprendimos a utilizar Swagger/OpenAPI para documentar nuestra API de manera detallada.
- Agregamos descripciones, títulos y agrupamos los endpoints por tags para mejorar la documentación.
- Realizamos commits y pushes al repositorio para mantener el control de versiones.

## Configuración de la base de datos de prueba:
- Utilizamos la anotación @DataJpaTest para indicar que vamos a probar la capa de persistencia.
- Configuramos el uso de una base de datos externa para las pruebas, en lugar de la base de datos en memoria.
- Creamos un perfil de prueba (application-test.properties) para separar la configuración de la base de datos de producción.
- Aprendimos a indicar el perfil de prueba a utilizar con la anotación @ActiveProfiles("test").
- Configuramos la creación automática de la base de datos de prueba en caso de que no exista.

## Pruebas automatizadas:
- Comenzamos a implementar pruebas unitarias para los métodos del repositorio de médicos.
- Utilizamos la anotación @AutoConfigureTestDatabase para indicar que no queremos reemplazar la base de datos externa.
- Aprendimos a generar automáticamente las clases de prueba a partir de los métodos del repositorio.
- Revisamos cómo ejecutar las pruebas y corregir los errores que puedan surgir.

---

🖥️ En resumen, en este curso aprendimos a documentar nuestra API de Spring Boot 3 utilizando Swagger/OpenAPI, a configurar una base de datos de prueba separada de la de producción, y a implementar pruebas unitarias automatizadas para nuestros repositorios. Esto nos ayudará a mantener un código más robusto y fácil de mantener a lo largo del desarrollo del proyecto.

