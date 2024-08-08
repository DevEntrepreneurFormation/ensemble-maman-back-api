FROM eclipse-temurin:21
VOLUME /tmp

ARG APP_ENV=DEV

ENV DB_URL=jdbc:mysql://host.docker.internal:3306/ensemble_maman?serverTimezone=UTC
ENV DB_DATABASE=ensemble_maman
ENV DB_USER=root
ENV DB_PASSWORD=narutouzumaki

COPY target/*.jar app.jar
EXPOSE 9000


ENTRYPOINT ["java","-jar","/app.jar"]