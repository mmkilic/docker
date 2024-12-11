FROM maven as builder
COPY . .
RUN mvn package -Dmaven.test.skip

FROM openjdk:17.0.2-jdk
COPY --from=builder ./target/demo-V0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
