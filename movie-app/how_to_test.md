# Movie Application

Build Restful for a Movie Application using Spring Boot, Mysql, JPA and Hibernate.
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