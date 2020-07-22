FROM amd64/openjdk:8

MAINTAINER "kelly"

COPY restAPI-Hibernate-0.0.1-SNAPSHOT.jar /restAPI--Hibernate-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/restAPI-Hibernate-0.0.1-SNAPSHOT.jar"]
