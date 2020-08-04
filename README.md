# 

## backend

### Build Spring Boot Project with Maven
To be able to run your Spring Boot app you will need to first build it. To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command. You will need to run it from the project folder which contains the pom.xml file.

```
maven package
```

or you can also use

```
mvn install
```

### Run Spring Boot app using Maven
Use the below example to run your Spring Boot app with Maven plugin:

```
mvn spring-boot:run
```

### Guides
[Spring-boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/html/)

## frontend

### Project setup
```
yarn install
```

### Compiles and hot-reloads for development
```
yarn serve --port 3000
```

### Lints and fixes files
```
yarn lint
```

### Guides
[Vue Guide](https://vuejs.org/v2/guide/)

## Some issue to know
1. This test environment is
    - backend
        - Spring Boot 2.2.2.RELEASE
        - Maven 3.6.3
        - MariaDB 10.5.4 Stable
    - frontend
        - @Vue/cli 4.4.6
