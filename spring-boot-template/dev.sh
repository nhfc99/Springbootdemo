docker stop javavr
docker rm javavr
docker rmi javavr:v0.1
docker build -t javavr:v0.1 .
docker run -d -p 8899:8899 --restart always --name javavr javavr:v0.1 /bin/bash

