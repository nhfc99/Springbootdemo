FROM openjdk:8-jdk-alpine
COPY /target/zzty_project_server.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#打包方式
#1.先使用mvn package进行打包成jar文件
#2.使用 docker build -t zzty_project_server:v0.1 .   进行打包成镜像文件
#3.创建容器 docker run -d -p 9000:9000 --restart always --name zzty_project_server zzty_project_server:v0.1 /bin/bash


