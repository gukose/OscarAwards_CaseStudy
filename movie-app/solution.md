# Movie Application

Build Restful for a Movie Application using Spring Boot, Mysql, JPA and Hibernate.

## Solution

**Description:**

This project follow the MVC pattern, where there are some controllers, some services, and some repository for data access. Basically, folder structure, it kept all controllers in the controller package, services in the service package, and repositories in the repository package.

+ <b>Controller:</b><br>
Controller layer depends on the service layer and is responsible for the incoming requests and the outgoing responses. A controller determines all the available endpoints that client side (or other api) is able to call. This layer should not apply logic on the receiving or returning data.
<br><br>
+ <b>Service:</b><br>
  Service layer depends on the repository layer and provides separation of concern, encapsulating all the business logic implementation. It is there to apply business rules on data sent to and from the repository layer. Service layer does not care about the specific database implementation and provides loose coupling.
  <br><br>
+ <b>Repository<b><br>
  Repositories are interfaces that are responsible for data persistence and retrieval. The repository layer is an abstraction that provides all CRUD functionality and keeps hidden the data related information) from the other layers.
  <br><br>
+ <b>Model<b><br>
  Domain model is organized under the model package and it consists of entity classes. Entities use various annotations that describe the relationships between each other. All these annotations are used by JPA in order to map entities to database tables.
