# rest-calculator
Calculadora de números expuesta mediante arquitectura RCP

##Futura escalabilidad del producto
Para lograr escalabilidad del proyecto es necesario delegar la persistencia de la sesión,
que se implementa en el servicio ISessionService, en un tercero especializado.

##Alta disponibilidad
Por tratarse se servicios que realizan operaciones sin estado (Stateless) 
(O el estado se ha delegado en una clase de manera threadSafe) la aplicaciòn no presenta problmas
de concurrencia. Así mismo se han especificado valores para el pool de hilos del servidor,
para evitar consumo de memoria

##Elasticidad
La forma més eficiente de lograr la elasticidad para la aplicación es aprovechar los recursos con
los que cuentan los diferentes proveedores de nube y, en el caso de AWS desplegar como un proyecto 
lambda_application con ayuda de SAM y AWS cli