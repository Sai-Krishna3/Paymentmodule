FROM openjdk:8
ADD target/PaymentModule-0.0.1-SNAPSHOT.jar PaymentModule-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","PaymentModule-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080