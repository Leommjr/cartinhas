FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM quay.io/wildfly/wildfly
COPY --from=build /workspace/target/*.war /opt/jboss/wildfly/standalone/deployments/app.war
