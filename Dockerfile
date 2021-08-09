FROM openjdk:11
ADD target/githubapi-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar githubapi-0.0.1-SNAPSHOT.jar
