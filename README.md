# WebSecureUsers
Spring Web App

a) H2 DATABASE:
   -    running the app will be automatically created the 3 tables containing:
        - set of roles in ROLES_USERS (Admin, User)
        - 1 new user with Admin role in USERS ->    email:      test0@test.com 
                                                    password:   test00
   -    WebApp homepage localhost:8080
   -    any new user registrated will be with "User" role
   -    to check the database connect to the page localhost:8080/h2
        -   JDBC URL: 	jdbc:h2:mem:exerciseDB
        -   User Name:  root
        -   Password:   root
   



b) mySQL DATABASE:

1.  In mySQL create new schema "exerciseDB" 
    in order to create the database
2.  Run src/test/java/com/exercise/WebSecureUsers/RoleRepositoryTests.java 
    in order to create new roles table with values
3.  src/main/resources/application.properties (line 4) -> change from "create" to "none" 
    in order to don't replace tables
4.  Run the Main class src/main/java/com/exercise/WebSecureUsers/WebSecureUsersApplication.java 
    in order to start the web application
5.  Open on browser the page localhost:8080
6.  Register the first user (will be with user role)
7.  Register the second user (will be with user role as well)
8.  Run testAddRoleToExistingUser in src/test/java/com/exercise/WebSecureUsers/UserRepositoryTests.java 
    in order to add Admin role to the first user
