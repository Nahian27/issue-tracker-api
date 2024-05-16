FROM bellsoft/liberica-openjdk-alpine:21

EXPOSE 8080

COPY . .

RUN ./mvnw clean package -DskipTests

CMD java -jar /target/*.jar