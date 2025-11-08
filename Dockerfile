FROM openjdk:17
#EXPOSE 8081
ADD ./target/*.jar app.jar
ENV MYSQL_HOST=host.docker.internal
ENTRYPOINT [ "java", "-jar", "/app.jar" ]

#docker run --name=micro-poc -p 8081:8080 -it micro-poc:2