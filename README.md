# Chat-Room
Simple JAVA EE chat room project.
# Usage
- Download/clone this project and run it in Eclipce or any IDE :
  
  ```shell
  git clone https://github.com/hatimzh/Chat-Room.git
  ```
  - <a href="https://github.com/hatimzh/Chat-Room/archive/refs/heads/main.zip">Zip file</a>

## Docker

- Build docker image

```shell
docker image build -t chat-hatim:1.0.0 .
```

- Run application

```shell
docker run --rm -p 8080:8080 chat-hatim:1.0.0  
```

Visit http://localhost:8080


## Demo 

https://github.com/hatimzh/Chat-Room/assets/96501113/50d3b32f-ef6b-4409-86ca-d1170b87129c


> **Note :** _if you don't want to start the project with an empty database, you should change the "create" value with "update" in this <a href="https://github.com/hatimzh/Chat-Room/blob/main/src/main/java/Hibernate.cfg.xml#L25">line</a>_

