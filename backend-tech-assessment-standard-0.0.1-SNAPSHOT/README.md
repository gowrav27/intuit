# backend-tech-assessment

Skeleton project for Backend Technical Assessment.

Includes
--------
- Maven - [pom.xml](pom.xml)
- Application properties - [application.yml](src/main/resources/application.yml)
- Runnable Spring Boot Application - [BackendTechAssessmentApplication](src/main/java/com/intuit/cg/backendtechassessment/BackendTechAssessmentApplication.java)
- REST endpoints - [RequestMappings.java](src/main/java/com/intuit/cg/backendtechassessment/controller/requestmappings/RequestMappings.java)

Requirements
------------
See Backend Technical Assessment document for detailed requirements.

To Run
MVN Clean Package
then,
java -jar -Dspring.profiles.active=test target/backend-tech-assessment-standard-0.0.1-SNAPSHOT.war

Create Seller:
http://localhost:8080/sellers
JSON:
{
"sellerName" : "Intuit2"
}

Get All sellers:
http://localhost:8080/sellers

Create Projects
http://localhost:8080/projects?sellerId=1
{
"projectName" : "MaxBudget",
"description" : "Hillary Clinton owns Hilton",
"maxBudget" : 5000,
"lastDate" : "2012-04-21T18:25:43-05:00"
}

Get all projects:
http://localhost:8080/projects