# Enterprise All Inclusive # 
_December 2023_
### Description ### 
This is a Kotlin REST API for a multi-tenant application.

### Technology Stack ###
- Maven
- Kotlin
- Springboot
- Postgres Database
- Dockerfile & docker-compose
~~~~
### Instructions ### 
*Note:* _These instructions are specific for Mac OS._
1. Install **Maven** and **Docker** onto your machine
1. Open Terminal > Navigate into *EAI* project folder
1. Build Project using Maven: <br>
   &nbsp; `mvn clean install`
1. Start Docker Containers<br>
   &nbsp; `docker-compose up`
1. Stop Docker Containers<br>
   &nbsp; `docker-compose down --rmi all`

### Database Access ###
You can access pgAdmin at http://localhost:5050. <br>
Find credentials in docker-compose.yml.

### API Access ###
You can make API calls to http://localhost:8080/transaction. <br>
include JSON RequestBody using Transaction dataclass


### To Do ###
- Add .env file
- Add API endpoints
- Update Database Script to include Audit Log
- Verify Database connection
- Verify API endpoints with PostMan
- Include Docker Volumes
- Add Unit Tests

### Bugs ###
- Dependency version issues in pom.xml and kotlin-app docker container

