# Enterprise All Inclusive # 
_December 2023_
### Description ### 
This is a Kotlin REST API for a multi-tenant application.

### Technology Stack ###
- Maven
- Kotlin
- Springboot
- Postgres Database

### Instructions ### 
*Note:* _These instructions are specific for Mac OS._
1. Install **Maven** and **Docker** onto your machine
1. Open Terminal > Navigate into *EAI* project folder
1. Build Project using Gradle: <br>
   &nbsp; `mvn clean install`
1. Start Docker Containers<br>
   &nbsp; `docker-compose up`
1. Stop Docker Containers<br>
   &nbsp; `docker-compose down --rmi all`

### Database Access ###
You can access pgAdmin at http://localhost:5050. 
Find credentials in docker-compose.yml.

### To Do ###
- Add .env file
- Add API endpoints
- Add Unit Tests
- Create Database Script

