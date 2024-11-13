BUILDER := gradle:8.10.2-jdk21-alpine

build-jar:
	docker buildx build -o docker/jar .

boot-jar:
	docker run -v .:/app -w /app $(BUILDER) \
	gradle --rerun-tasks --no-daemon \
	app-book:build app-store:build

http-yac:
	docker run --net=host -it -v ${PWD}/http:/data ghcr.io/anweber/httpyac:latest httpyac .