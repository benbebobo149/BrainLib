# Brainlib 
This is the application that let scholar to publish post and create the event.

# how to install

Before you start this project, remember to ask the admin to give you the github access token. 

```
cd /home

sudo git clone https://github.com/benbebobo149/BrainLib.git

sudo chown -R <your-username> /home/BrainLib/ 

cd /home/BrainLib/ 

sudo docker compose up -d

```
If you use the Window system, openning the Docker Desktop before running docker compose.

## git commit

init: 初始化專案

add: 新增項目（但功能未完成）

feat: 新增功能（功能已完成）

RWD: RWD 的功能修正

chore: 雜務（如新增附件檔、上傳字體檔等等）

fix: 修正 bug 或 issue


hotfix: 「即時」修正嚴重 bug

範例：

- 上傳圖片、字型: "chore: upload images and fonts"
- 修正部分裝置的 RWD: "RWD: adjust layout on tablet"
- 完成桌機頁面: "feat: complete desktop and tablet layout"

## branch

before you start your project please create your branch first.

```
git checkout -b <your name>
```

when you finish your job, you need to push your progress to github 

```
git push
```

**Do not push to the main branch !**

## set up only one container

1. backend
```
docker build -t spring_env .
docker run -it --name spring -v ./:/app/backend/ -w /app/backend -p 8080:8080 -d spring_env
docker exec -it spring /bin/sh
./gradlew bootRun
```

2. frontend
```
docker image build -t nuxt3-env .
docker run -it --name nuxt -v .:/app -p 3000:3000 -d nuxt3-env
docker exec -it nuxt /bin/sh
```

## naming convention

### frontend 

vue3 (follow the guideline at least Level B): https://vuejs.org/style-guide/

The image should be put in the public/ and create a directory corresponding to the pages directory.

ex: avatar.png will be used in /pages/posts/index.vue, so it will be put in /public/posts/.

The components should be put in the components/ and create a directory corresponding to the pages directory.

ex: ToDoListModal.vue will be used in /pages/posts/index.vue, so it will be put in /components/posts/.

### backend 

database : 
- all the names are snake_case style 
- table name should be plural
- collumn name should be singular

java : follow the tradition of oracle https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html

## framework and library 
frontend : nuxt3 + tailwind

database : postgres + adminer

backend : spring + spring data jpa + oauth2 client + jwt 