# Springboot-Microservices project

## Welcome to the project
This project is created with a primary objective - `Sample application, to showcase & understand the development process using Github, associated branching & merge strategies provided with Github`

If you want digital decoupling, this is the technology that you should invest 30 minutes of your time to try it out.

## Pre-requisites
The pre-requisites are very minimal.
 - Foundation technology requires only Java 1.8 JDK or above (Oracle or OpenJDK)
 - Maven build system ("mvn")
 - Docker / Kubernetes are optional

 Application module that you create can be run in bare metal, VM and any cloud environment(s).

## Original project
This project was generated using `Spring Initializer` - https://start.spring.io/
Further modifications are applied on top of the base application for demonstration purposes


## Microservices principles
3 architecture principles advocated to write microservices

- minimalist: user software developed as small as possible
- event driven: loose coupling and distributed architecture, promote concurrency & independence (adapt `separation of concerns` principle)
- context bound: encapsulate business logic / application code from consumers by defining an API contract

### How this repository is organized
Repository follows typical maven project structure
    - src/main/java - contains the source code classes
    - src/main/resources - resource files - properties, yml, etc.
    - src/test/java, src/test/resources - junit tests (static code analysis & code coverage)
    - pom.xml - Maven dependencies

### Before you start

If you haven't already, please start a terminal and clone the repository.
Collaborators can optionally fork the repository and contribute as well.

```

git clone https://github.com/raghavendrarao4/springboot-microservices
cd springboot-microservices

```

### To run the application
You can compile the project, which creates an executable jar adapting the steps below.
Run the jar file to start the springboot application.

```

cd springboot-microservices
mvn clean
mvn install

java -jar target/demo-0.0.1-SNAPSHOT.jar

```
