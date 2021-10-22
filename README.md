# jumiaApp
A  web Application that render a list of all phone numbers available in the DB and allow to filter by country and state

To make it easier to divide this Readme into 5 different parts. The first one I will cover the functional requirements and the application architecture, the second I will cover about Importing the projects and Packaging Structure, the third I will focus on Running the BackEnd and the FrontEnd on your machine with or without Docker.😎

## 1 - Functional requirements and Architecture

Basically all the application needs to do is validate a list of phone contacts through regular expressions in order to know if these contacts are valid or not. Well, there are several ways to solve this problem, I found three different ways to solve this problem myself, but I chose the simplest one. I could have used inheritance, ManyToMany relationship or Composition composition but I found a much simpler way 🙂.

Below is the application's architecture:

![image](https://user-images.githubusercontent.com/17338297/138110473-becf1fa2-0701-4550-85d9-3077c2ef3ca1.png)

## EndPoint Implementation

- List all customers with contacts validated or not.
- List all customers
- Filter all customers by state
- Filter all customers by country
- Validate customer by phone

## What we will build

appCustomer: This project is used to develop Customer RESTFul APIs for a simple Customer Phone Management System using Spring Boot 2, JPA and SQLlite as a database.

angular12-springboot-client: This project is used to develop single page application using Angular 12 as front-end technology. This Angular 12 application consumes the Restful APIs developed and exposed by a appCustomer project.

Below are the screenshots shows UI of our Customer Phone Management System App:

![app](https://user-images.githubusercontent.com/17338297/138316390-ba6bfbaf-672e-40cc-8bc9-346782273a3a.PNG)


## Tools and technologies used

**Server-side technologies**
- Spring Boot - 2.5.5.RELEASE
- JDK - 11 or later
- Spring Framework - 5.0.8 RELEASE
- Hibernate - 5.4.31.Final
- Spring Data JPA - 2+
- FlyWay 8.0.2

**Front end technologies**
- Angular 12.2.10
- npm- 6.14.15
- Maven - 3.8.1
- IDE - IntelliJ
- Angular CLI

## Architecture of our Spring boot project
![image](https://user-images.githubusercontent.com/17338297/138145574-3bda127e-6f46-4740-90b2-efd303a5d698.png)

## Spring Boot Customer Management Rest APIs Development


|  NO |   API Name                      | HTTP Method  |          Path                        |    Status Code     |    Description  
|-----|---------------------------------|--------------|--------------------------------------|--------------------|----------------------
|  1  | GET AllCustomers                |  GET         | api/v1/getAllCustomers               |       200(OK)      |  Return all customers from databse             
|  2  | GET AllCountries                |  GET         | api/v1/getAllCountries               |       200(OK)      |  Return all Country and Phone from database
|  3  | GET CustomerValidated           |  GET         | api/v1/getCustomerValidated          |       200(OK)      |  Return all Customers Validated Phone from database
|  4  | GET CustomerValidatedByState    |  GET         | api/v1/getCustomerValidatedByState   |       200(OK)      |  Filter Validated phones from database by State
|  5  | GET CustomerValidatedByCountry  |  GET         | api/v1/getCustomerValidatedByCountry |       200(OK)      |  Filter Validated phones from database by Country


 ## 2 - Importing the projects and Packaging Structure
 
 There are many ways to import a Spring Boot application. The simplest way is to use your IntelliJ Menu and click **OPEN** and the search the project and that's it!
 
 #Packaging Structure#
 
 ![image](https://user-images.githubusercontent.com/17338297/138173072-478711c3-2f08-4e1b-b588-cd58cd9deae9.png)
 
 ## 3 - Running the BackEnd and the FrontEnd
 
**BackEnd** 

Run A Spring Application is the easiest thing on the because Spring Boot Application arives with embeded application Server (TomCat) and it allow us to run the project with few lines of code. 
On your IDE terminal run the follows scrpts:
   - (1) mvn clean package
   - (2) java -jar target/myJavaProject.jar

After that the server will be running on port 8080.  
  
 Another simple way is go Inside the project folder, open CMD and your run this code: **java -jar target/appCustomer-0.0.1-SNAPSHOT.jar** If all goes well, the application will be running on localhost on **port 8080**.
 
**FrontEnd**

Run A Spring Application is the easiest thing on the because Spring Boot Application arives with embeded application Server (TomCat) and it allow us to run the project with few lines of code. 
First of all make your that you hava the Node and NPM installed and then you can run the frontend with this two steps inside the frontend folder:
   - (1) npm install
   - (2) ng serve

After that the server will be running on port 4200.

## Using Docker ##
Fist of all, make sure that you already have the Docker installed on your machine and then run this scrips on the root of project. 


**Backend** (appCustomer)
  - (1) docker build -t spring-app .
  - (2) docker run -p 8080:8080 jumia-app
  - (3) Done! The application will be run on port 8080
  
**Frontend** (frontend-app)
  - (1) docker build -t jumia-frontend-app .
  - (2) docker run -p 4200:4200 jumia-app
  - (3) Done! The Frontend application will be run on port 4200
  
  
After those steps the application will be running perfectly.

Thanks :)

 
