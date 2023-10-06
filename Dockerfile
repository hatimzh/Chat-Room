FROM amazoncorretto:8-alpine3.18-jdk as build

COPY . /hatim/app

RUN cd /hatim/app/src/main/webapp && jar cvf ROOT.war .

FROM tomcat:jre11-temurin
COPY --from=build /hatim/app/src/main/webapp/ROOT.war /usr/local/tomcat/webapps/
