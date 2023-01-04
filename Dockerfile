FROM openjdk:latest
ADD /home/runner/work/DispBackend/DispBackend/target/DispBackend-0.0.1-SNAPSHOT.jar DispBackend-0.0.1-SNAPSHOT.jar.jar
ADD docker-utils/wait-for-it.sh wait-for-it.sh
EXPOSE 8080
CMD chmod +x wait-for-it.sh
ENTRYPOINT ["./wait-for-it.sh", "postgres_db:5432","--","java", "-jar", "auth-0.0.1-SNAPSHOT.jar","--spring.datasource.url=jdbc:postgresql://postgres_db:5432/spring_jwt"]
