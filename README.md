# MarketPlace

## Description
This is a simple demo service for the BrasilPrev Challenge.  Please, note that this is a simplistic service,
 and a real system used by enterprises would require a bigger and more detailed representation that better fits 
 into the correspondent business case. I had to make some choices in order to minimize the costs, make It simple to understand
  and to deliver It under the desired time. As an improvement, I would personally suggest the following todo list for such 
  system thinking in a long term and real case:

- Brake this service into many micro services that represents only one responsibility each. 
- Create a proper CICD that runs all tests, run some analysis based on SonarLint or SonarQube and allocates the correspondent
  machine resources to each pod (Kubernetes).
- Create Integration Tests among the micro services to ensure all functionalities would not be compromised by new code.
- Transform all HTTP requests into HTTPS requests. This one would require a custom bought SSL certificate and networking
  configuration.
- Change to a real database. To make simple and yet a faster development, I have used the H2 in memory database. 
  In case of restating the service, all the before stored data will be lost. Again, this is just a simple demo.
- Use of environment variables for each environment (e.g. development, testing and production environments).

## How to used
This a back-end solution made using Java 14, Spring MVC and Maven as main structure. To install and compile all
 the dependencies simply run mvn clean install on the root directory.
 
All the documentation is provided thought Swagger web page and Javadoc present on each Java class.

After compiling, you need to run the Application.java class to raise the micro service instance.

## Swagger
The swagger web page can be accessed by the path {host}/marketPlace/swagger-ui.html as soon as the service is up.

For example, a local service has the swagger path localhost:8080/marketPlace/swagger-ui.html.

## Heroku
I have deployed the service using Heroku. It can be accessed by the url: 

https://caliarichallenge.herokuapp.com/marketPlace/swagger-ui.html#/
