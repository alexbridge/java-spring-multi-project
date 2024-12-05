BUILDER := gradle:8.10.2-jdk21-alpine

build-single:
	docker build --build-arg SPRING_JAR=app-books-server-1.0.0.jar -t io-example:books .
	docker build --build-arg SPRING_JAR=app-store-server-1.0.0.jar -t io-example:store .

docker-compose:
	docker compose up --build