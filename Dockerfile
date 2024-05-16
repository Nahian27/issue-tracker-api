FROM bellsoft/liberica-openjdk-alpine:21

COPY . .

RUN ./mvnw clean package -DskipTests

CMD java -jar /target/*.jar