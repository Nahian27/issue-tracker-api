FROM bellsoft/liberica-openjdk-alpine:21

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD java -jar /target/*.jar