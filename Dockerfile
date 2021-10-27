FROM openjdk:14-alpine
COPY build/libs/demo-*-all.jar demo-0.1.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "demo-0.1.jar"]