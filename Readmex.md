
# ITIL
## Introduccion y Estrategia del servicio

### Que es ITIL(Information Technology Infraestructure Library)?

Conjunto de buenas practicas para la gestion de servicio TI que permite alinear los servicios a las estrategias del negocio.

#### Que son buenas practicas

Conjunto de gias que surgen de:

* Las mejores experiencias
* De los profesionales mas calificados y experimentados
* En un area de dominio especifico

#### En que se basa?

* Mas de una persona
* Mas de una organizacion
* Mas de una tecnologia
* Mas de un evento

 
#### Objetivos
1. Alinear los servicios IT con las necesidades actuales y futuras del negocio y sus clientes
2. Mejorar la calidad de los servicios entregados
3. Reducir el coste a largo plazo de la provisión de los servicios


• ITIL establece procesos para conseguir prestar servicios de forma óptima
• Implantar ITIL en una organización impacta directamente contra la cultura de la misma

#### Servicio

Es un medio para entregar valor a los clientes facilitandoles un resultado deseado sin la necesidad que estos asuman los costes o los riesgos especificos asociados.

#### Ciclo de vida de un servicio `EDTOM`

* Estrategia del servicio: Crea servicios que se conviertan en activos de la organizacion 
	+  Genracion de la Estrategia
	+  Gestion
		- Portafolio de los servicios
		- Finaciera para los procesos de TI
		- Demanda
		- Relaciones con el negocio
	

* Diseño del servicio:  Diseñar el servicio cumpliendo con las especificaciones en la estrategia y con las posibilidades de la organizacion, basandose en las plataformas disponibles y creando un paquete de diseño con las especificaciones para su construccion
	+ Coordinacion del diseño
	+ Gestion
		- Catalogo de servicios
		- Niveles o de los servicios
		- Disponibilidad
		- Capacidad
		- Continuidad del servicio
		- Seguridad de la Informacion
		- Proveedores

* Transicion del servicio: Construir servicios nuevos o modificar existentes tomados como entrada el paquete de diseño y llevandolos hasta produccion

	+ Planeacion y soporte de la transicion
	+ Gestion
		- Cambios
		- Activos de Servicios de configuracion
		- Implementaciones 
		- Validacion y pruebas del servicio 
		- Evaluaciones y cambios
		- Conocimiento

* Operacion del servicio: Realiza las actividades dia a dia para asegurar que el servicio se entrega con utilidad y garantia al cliente.

	+ Gestion
		- Eventos
		- Incidentes
		- Problemas
		- Accesos
	+ Cumplimiento de solicitudes

* Mejora Continua del Servicio: Es la fase donde se mide lo que tenemos y se descubre las brechas para mejorar los servicios y resultados del servicio.


#### Organizaciones Involucradas

* Desarrollada y Mantenida por la OGC The office goverment Commerce
* TSO The Stationary office se encarga de publicar officialmente la documentacion ITIL.
* El AMP  Group  (AMPG) es el acreditador official de ITIL.
* EXIN Examitanion Instute of Information Science, es el desarrollador official de los examenes de certificacion.




#JAVA EE
##EJB
Un enterprise java bean son clases puras de java (POJO's) que generalmente contienen la logica de negocio, los cuales poseen caracteristicas mucho mas potentes y robustas que los Java Beans.

* Los métodos de un EJB son transaccionales.
* Los métodos pueden ser:
	- seguros.
	- asíncronos.
	- remotos
* Facilidad de comunicación con las bases de datos.

Los EJB’s al ejecutarse dentro de un contenedor EJB y a su vez dentro de un servidor de aplicaciones Java, tiene a su disposición varios servicios que puede utilizar, tales como:

* Seguridad
* Servicio de Inyección de Dependencias por medio de CDI
* Servicio de Pool de Conexiones
* Interceptors, permiten interceptar llamadas a métodos y agregar funcionalidad extra o complementaria por medio de AOP (Aspect Oriented Programming)
* Llamadas Asíncronas
* Llamadas Remotas por medio de RMI
* Manejo de:
	+ Transacciones por medio de JTA
	+ Concurrencia Segura (Tread-Safety)
	+ Tareas Programadas (Scheduling)
	+ Mensajería por medio de JMS
* Exposición de reglas de negocio por medio de Servicios Web (JAX-WS o JAX-RS)



### TIPOS DE EJB

EJB de Sesión: Un bean de sesión se invoca por el cliente para ejecutar una operación de negocio específica.

* Stateless: Este tipo de EJB no mantiene ningún estado del usuario, es decir, no recuerda ningún tipo de información después de terminada una transacción.

* Stateful: Este tipo de EJB, mantiene un estado de la actividad del cliente, por ejemplo, si se tiene un carrito de compras. Este estado se puede recordar incluso una vez terminada la transacción, pero si el servidor se reinicia esta información se pierde. El similar al alcance Session de una aplicación Web.

* Singleton: Este tipo de beans utiliza el patrón de diseño Singleton, en el cual solamente existe una instancia en memoria de esta clase.

**Otras clasificaciones que podemos encontrar son:**

* EJB Timer: Esta es una característica que se puede agregar a los beans, para que se ejecuten en un tiempo especificado (scheduling).

* Message-driven beans (MDBs): Este tipo de beans se utiliza para enviar mensajes utilizando la tecnología JMS. El estudio de este tipo de beans queda fuera del alcance de este curso.

* Entity Beans: Esta es una clasificación anterior a la versión 3 de los EJB, sin embargo al día de hoy el estándar JPA (Java Persistance API) ha sustituido a este tipo de beans. Así que, a menos que estemos utilizando una versión anterior a la versión 3, se debería utilizar JPA en lugar de los Entity Beans.


### CONFIGURACION DE UN EJB
Los EJBs pueden ser configurados de la siguiente forma, con el objetivo de permitir la comunicación con sus métodos:

1. INTERFAZ LOCAL 

Estas interfaces contienen la declaración de los métodos de negocio que son visibles al cliente. Estas interfaces son implementadas por una clase Java.

2. UNA CLASE JAVA BEAN 

Esta clase implementa los métodos de negocio y puede implementar cero o más Interfaces de Negocio. Dependiendo del tipo de EJB, esta clase se debe anotar con @Stateless, @Stateful o @Singleton dependiendo del tipo de EJB que deseemos crear.

### FORMAS DE COMUNICACION CON UN EJB


* Interfaz Local: Se utiliza cuando el cliente se encuentra dentro del mismo servidor Java, de esta manera se evita la sobrecarga de procesamiento al utilizar llamadas remotas vía RMI.
 
* Interfaz Remota: Se utiliza cuando el código del cliente está fuera del servidor de aplicaciones Java (en una Java Virtual Machine distinta) y por lo tanto debemos hacer llamadas remotas para poder ejecutar los métodos del EJB.

* No Interface: Es una simplificación en la versión 3, ya que no se requiere de una interfaz para establecer la comunicación, siempre y cuando las llamadas sean locales, es decir, dentro del mismo servidor de aplicaciones Java.

### CLIENTE EJB VIA JNDI

JNDI (Java Naming and Directory Interface) es un API que nos permite encontrar servicios o recursos en un servidor de aplicaciones Java.

En un inicio JNDI era la única manera de encontrar los componentes EJB, pero conforme se introdujo el concepto de EJB locales y el manejo de anotaciones existieron otras maneras de ubicar y proporcionar una referencia de los componentes empresariales que se necesitan, a este concepto se le conoce como inyección de dependencias.


#JPA
Estandar de persistencia de java. Implementa los conceptos de frameworks ORM(Object Relational Mapping)

## Caracteristicas

* Persistencia utilizando POJO's
* No intrusivo
* Consulta utilizando Objetos Java
* Configuracion Simple
* Integracion 
* Testing

## Patrones utilizados para la persistencia

* DAO(Data Acces Object): Define un interfaz y una implementacion de esa interfaz para realizar las operaciones mas comunes con la entidad respectiva.

* DTO(Data transfer Object): Conocido como BO o value object, este patron define una clase similar a la entidad con la finalidad de transmitir datos a las demas capas, incluso a la capa web;



# Servlet
Es un componente basico que permite procesar peticiones HTTP, lee informacion del cliente web y generar una respuesta para mostrar al cliente(Html y archivos binarios como PDF, audio, video .. etc), poseen un ciclo de vida bien definido y son administrados por un contenedor de aplicaciones web java.

## Definicio de un servlet
````
@WebServlet("/ServletControlador","/")
public class ServerControlador extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	{
	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
	
	}
}

````

## Funciones de un servlet

* Contiene codigo java y puede agregar codigo HTML.
* Un servlet web se utiliza como una clase que controla el flujo de una aplicacion web(Controlador) en una arquitectura MVC

#### FILTROS @WebFilter- doFilter

web.xml

````
<filter>
	<filter-name>MiFiltro</filter-name>
	<filter-class>com.proyecto.MiFiltro</filter-class>

</filter>

<filter-mapping>
	<filter-name>MiFiltro</filter-name>
	<url-pattern>/admin.jsp</url-pattern>
</filter-mapping>
````

````
@WebFilter(filterName = "MyFilter", urlPatterns = {"/*"})

````

#### NUEVAS CARACTERISTICAS EN SERVLETS 3.X
1. Facilidad de desarrollo 
2. Registro Dinamico de los servlets y filtros
3. Comparticion de recursos
4. Llamadas Asincronas
5. Mejoras en el Api de seguridad


### JSP
Los JSP son componentes del lado del servidor especializados en manejar codigo html  e incrustar codigo java por medio de tags.

Los JSp son utilizados como componentes de presentacion  es decir para mostrar la informacion obtenida o procesada por los Servelets.

Un JSP al compilarse crea de forma automatica un servelet es por eso que su ciclo de vida es similar;

#### TECNOLOGIAS EN LA QUE SE APOYA JSP

**EXPRECION LANGUAJE EL**: Simplifica el acceso a la informacion compartida por los servlets segun el modelo MVC y con ello el JSP se enfoca en la tarea de procesar la informacion para retornar una respuesta al cliente

**JSTL**: (JavaServer Pages Standard Tag Library): Es un conjunto de etiquetas que usamos en los jsp y nos permite simplificar tareas en las que  comunmente tendriamos que agregar codigo java, permitiendo un codigo mas limpio y mantenible.

````
<c:forEach var="persona" items="${personas}">
	<tr>
		<td>${persona.nombre}</td>
	</tr>
</c:forEach>
````

#### Session
















