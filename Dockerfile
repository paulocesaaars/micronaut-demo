FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:14-alpine

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/demo-0.1.jar

CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "demo-0.1.jar"]