# Description
Application template for rapid start your web application (JETTY, SpringFramework, Spring-MVC, JSON, JDBC, PostgreSQL)

## Content
* Spring framework (core, MVC, JDBC) - **4.3.6.RELEASE**
* fasterxml.jackson - **2.8.6**
* JETTY embedded - **9.4.0.v20161208**
* PostgreSQL JDBC driver - **9.1-901.jdbc4**
* JDBC pool connection c3p0 - **0.9.2.1**

## Running
For running application use follow:
~~~~
mvn jetty:run
~~~~
or
~~~~
mvn jetty:run-war
~~~~
After running you can check test resources:
~~~~
GET http://localhost:8080/rest/test
~~~~
and
~~~~
GET http://localhost:8080/rest/mul/23,56
~~~~
