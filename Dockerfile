FROM java:8
ADD target/janaf-web-0.0.1.jar /opt/web-app/janaf-web.jar
EXPOSE 8080
WORKDIR /opt/web-app

ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "janaf-web.jar"]

