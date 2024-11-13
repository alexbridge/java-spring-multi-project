FROM gradle:8.10.2-jdk21-alpine AS builder

COPY --chown=gradle:gradle . /app

WORKDIR /app

RUN gradle app-books-server:build app-store-server:build --no-daemon

FROM scratch AS export-stage

COPY --from=builder /app/modules/app/books/server/build/libs/*.jar .
COPY --from=builder /app/modules/app/store/server/build/libs/*.jar .