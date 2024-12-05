FROM eclipse-temurin:21-jre-alpine

ARG SPRING_JAR

EXPOSE 8080 9999

RUN addgroup spring && adduser -DH -G spring spring

RUN apk add --no-cache curl tzdata

RUN mkdir /app


COPY jar/${SPRING_JAR} /app/spring-boot.jar
RUN chown -R spring:spring /app

USER spring

CMD ["java", "-jar", "/app/spring-boot.jar"]

HEALTHCHECK --interval=2s --timeout=5s --retries=10 \
    CMD curl -s http://localhost:8080 | grep 404 || exit 1