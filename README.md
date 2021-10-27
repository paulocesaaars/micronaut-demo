## Micronaut 3.1.1 Documentation

docker build -f Dockerfile -t demo.api .

docker-compose -f docker-compose.yml up --build

docker run --name demo.api -d -p 8080:8080 -e APP_URL=jdbc:postgresql://host.docker.internal:5432/demo -e APP_USERNAME:postgres -e APP_PASSWORD:paula@123 demo.api

