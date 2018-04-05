# call-center

[![Build Status](https://travis-ci.org/jkevingutierrez/call-center.svg?branch=master)](https://travis-ci.org/jkevingutierrez/call-center)

An API for manage a multithreaded call center using Spring Boot.

You can check the endpoints on [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) locally or [https://call-center-almundo.herokuapp.com/swagger-ui.html](https://call-center-almundo.herokuapp.com/swagger-ui.html)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* JDK 8
* Postgresql 9.6

### Installing

First build the project with maven

```
mvnw install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
```

Then execute the jar file

```
java -jar target/call-center-0.0.1-SNAPSHOT.jar
```

Open [http://localhost:8080](http://localhost:8080)

## Running the tests

```
mvnw test -B
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
