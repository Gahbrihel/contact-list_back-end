FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . /home/app/contact-backend
RUN mvn -v
RUN mvn -f /home/app/contact-backend/pom.xml clean package


#Step 2 - Run backend
FROM alpine/java:21-jdk
COPY --from=build /home/app/contact-backend/target/*.jar /usr/local/lib/contact-backend.jar
VOLUME /tmp
EXPOSE 80:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/contact-backend.jar"]
