
build:
	docker run -v ${PWD}:/opt -w /opt eclipse-temurin:21-jdk-alpine ./gradlew build

http-yac:
	docker run --net=host -it -v ${PWD}/http:/data ghcr.io/anweber/httpyac:latest httpyac .