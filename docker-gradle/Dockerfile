FROM gradle:7.6.4-jdk17-alpine as builder_gradle
COPY --chown=gradle:gradle . /home/gradle
ENV GRADLE_APP=/home/gradle
WORKDIR $GRADLE_APP
RUN gradle assemble

FROM openjdk:17.0.2-jdk
COPY --from=builder_gradle /home/gradle/build/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
