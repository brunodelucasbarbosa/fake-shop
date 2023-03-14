FROM azul/zulu-openjdk-alpine:17
EXPOSE 8080
ADD /build/libs/fakeshopusers-0.0.1-SNAPSHOT.jar fakeshopusers.jar
ENTRYPOINT ["java", "-jar", "fakeshopusers.jar"]