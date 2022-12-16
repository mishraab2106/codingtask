FROM openjdk:8
EXPOSE 8080
ADD target/e-newspaper.jar e-newspaper.jar
ENTRYPOINT ["java","-jar","/e-newspaper.jar"]