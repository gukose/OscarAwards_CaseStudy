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
+ <b>Repository</b><br>
  Repositories are interfaces that are responsible for data persistence and retrieval. The repository layer is an abstraction that provides all CRUD functionality and keeps hidden the data related information) from the other layers.
  <br><br>
+ <b>Model</b><br>
  Domain model is organized under the model package and it consists of entity classes. Entities use various annotations that describe the relationships between each other. All these annotations are used by JPA in order to map entities to database tables.


##How to Run
**1. Create Mysql database**
```bash
create database MovieDB or use which has been declared
```
- run `run src/main/resources/script.sql`

**2. If new database is created, change mysql username and password**

+ open `src/main/resources/application.properties`
+ change spring.datasource.username and spring.datasource.password

**3. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8091>


## How to Test

All APIs and sample requests have been added to the `src/main/resources/MovieApp.postman_collection.json` document.
Before sending token, Bearer token should be getting from sign-in response. Sign-in should be requested as given example in the postman collection or it can be recreated.
After getting Bearer token, it should be set as variable named 'UserToken'
### Auth

| Method | Url | Decription | 
| ------ | --- | ---------- | 
| POST   | /api/auth/signup | Sign up | 
| POST   | /api/auth/signin | Log in | 

### Users

| Method | Url | Description | 
| ------ | --- | ----------- | 
| GET    | /api/users/me | Get logged in user profile | 
| GET    | /api/users/{username}/profile | Get user profile by username | 
| GET    | /api/users/checkUsernameAvailability | Check if username is available to register | 
| GET    | /api/users/checkEmailAvailability | Check if email is available to register | 
| PUT    | /api/users/{username} | Update user (If profile belongs to logged in user or logged in user is admin) | 
| DELETE | /api/users/{username} | Delete user (For logged in user or admin) |
| PUT    | /api/users/setOrUpdateInfo | Update user profile (If profile belongs to logged in user or logged in user is admin) |

###Movie
| Method | Url                   | Decription                                                | 
|--------|-----------------------|-----------------------------------------------------------| 
| GET    | /api/movies/{nominee} | Get whether a movie won a “Best Picture” Oscar            | 
| POST   | /api/movies/rate      | Add a rating to movies                                    | 
| GET    | /api/movies/rate/top  | a list of 10 top-rated movies ordered by box office value |

Test them using postman or any other rest client.