FROM docker.io/clojure:latest
RUN apt update && apt install -y git
WORKDIR /app
COPY . .
RUN clojure -X:uberjar
EXPOSE 3000
ENTRYPOINT "java" "-jar" "/app/sample-app.jar"
