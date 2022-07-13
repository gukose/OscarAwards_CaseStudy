# Movie Application

Build Restful for a Movie Application using Spring Boot, Mysql, JPA and Hibernate.

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
