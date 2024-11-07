
http-yac:
	docker run --net=host -it -v ${PWD}/http:/data ghcr.io/anweber/httpyac:latest httpyac .