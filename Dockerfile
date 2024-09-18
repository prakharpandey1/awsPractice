FROM openjdk:17

WORKDIR /app

COPY /build/lib/AwsEc2-practice-0.0.1-SNAPSHOT.jar /app//build/lib/AwsEc2-practice-0.0.1-SNAPSHOT.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/app/AwsEc2-practice-0.0.1-SNAPSHOT.jar"]
