FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.DinBot
ENV BOT_TOKEN=5097486920:AAGF3MPgZj245f8wSGhmF9IRljh9k86dCWY
ENV BOT_DB_USERNAME=dev_jrtb_db_user
ENV BOT_DB_PASSWORD=dev_jrtb_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]
