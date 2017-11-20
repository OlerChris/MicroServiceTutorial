# Revature Staging

The purpose of this project is to serve as an example/tutorial for creating a microservice application. IntelliJ
was used as my IDE A account servive will handle login, logout, and registration. A messaging service will handle
group chats and the messages in them. Each milestone is kept in a branch called X#. The details of each are below.

    X# - synopsis

        Technologies:
            list of technologies used

        Tutorial points:
            notes about this step in development to learn

    ###################################################################################################

    X1 - Eureka finds the two services

        Technologies:
            Java - This project is based in Java 8
            Eureka - finds services
            Spring Boot - each service is a seperate spring boot application

        Tutorial points:
            going to localhost:1111 from browser will show Eureka details
            Eureka will find each service that is run

    ####################################################################################################
    
    X2 - Databases and access to those databases created

        Technologies:
            Oracle SQL - SQL dialect used to create database (hosted on Amazon RDS)
            SpringData - Framework to facilitate database access (in this step via repositories)
            Hibernate - ORM (Object Relational Mapper) provides JPA (Java Persistance Annotations)

        Tutorial points:
            Oracle SQL scripts given in X_SQL_X packages
            Tables and columns in database correspond to Beans and instance variables respectively
            Bean annotations are from Hibernate and map Java Objects to Database
            Repository Interface implementations are created by Spring
                more functionality can be added later by adding specific method stubs
            Converters automatically change the representation of Data between Server and Database
                ex. Integer security level in Database changes to Enum security level on Server

    ####################################################################################################


    X3 - APIs created for each of the services

        Technologies:
            REST - APIs use restful web design
            SpringMVC - Included inside SpringBoot, it manages routing of client requests
            Postman - Application outside Java used to test APIs

        Tutorial points:
            Each request goes through 3 steps
                controller - Calls a service to process and will send response
                service - handles logic involved and uses repositories to use database
                repository - created in X2, handles database transactions
            DataTransfer Objects are used by Controllers to communicate with clients
            Postman screenshots can be found in {service}/tutorialNotes/postmanScreenShots
            Security at this point is still nonexistent at this point but will be handled later
                Account info should be handled with Tokens and Oauth2 later

    ####################################################################################################

    Tech List

        Eureka      - X1
        Hibernate   - X2
        Java        - All
        Oracle SQL  - X2
        Postman     - X3
        REST        - X3
        SpringBoot  - X1
        SpringData  - X2
        SpringMVC   - X3

