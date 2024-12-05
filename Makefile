BUILDER := gradle:8.10.2-jdk21-alpine

build-docker-jar:
	docker buildx build -o docker/jar .

build-boot-jar:
	docker run -v .:/app -w /app $(BUILDER) \
	gradle --rerun-tasks --no-daemon \
	app-books-sever:build app-store-server:build

http-yac:
	docker run --net=host -it -v ${PWD}/http:/data ghcr.io/anweber/httpyac:latest httpyac .