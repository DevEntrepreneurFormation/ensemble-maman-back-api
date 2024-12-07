FROM eclipse-temurin:21
VOLUME /tmp

ARG APP_ENV=DEV

####### USE IT FOR PRODUCTION #######
# ENV DB_URL=jdbc:mysql://srv1424.hstgr.io/u848737602_ensemble_maman?serverTimezone=UTC
# ENV DB_USER=u848737602_root
# ENV DB_PASSWORD=ForTheKingAndForPeople777

ENV DB_URL=jdbc:mysql://host.docker.internal:3306/ensemble_maman?serverTimezone=UTC
ENV DB_DATABASE=ensemble_maman
ENV DB_USER=root
ENV DB_PASSWORD=narutouzumaki

COPY target/*.jar app.jar
COPY .env.properties .

EXPOSE 9000


ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.import=file:.env.properties"]