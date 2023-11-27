# Brainlib 
This is the application that let scholor to publish post and create the event.

## commit style
init: 初始化專案

add: 新增項目（但功能未完成）

feat: 新增功能（功能已完成）

RWD: RWD 的功能修正

chore: 雜務（如新增附件檔、上傳字體檔等等）

fix: 修正 bug 或 issue

hotfix: 「即時」修正嚴重 bug

## set up
git clone https://github.com/benbebobo149/BrainLib.git

docker-compose up -d

## set up only one container

1. backend
```
docker build -t spring_env .
docker run -it --name spring -v ./:/app -w /app/backend -p 8080:8080 -d spring_env
docker exec -it spring bash
mvn spring-boot:run
```

2. frontend
```
docker image build -t nuxt3-env .
docker run -it --name nuxt -v .:/app -p 3000:3000 -d nuxt3-env
docker exec -it nuxt /bin/sh
```

## framework and library 
frontend : nuxt3 + tailwind

database : postgres + adminer

backend : spring + hibernate