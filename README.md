# Chat-Room
Simple JAVA EE chat room project.
# Usage
- Upload/clone this project and run it in exlipce

## Docker

- Build docker image

```shell
$ docker image build -t chat-hatim:1.0.0 .
```

- Run application

```shell
$ docker run --rm -p 8080:8080 chat-hatim:1.0.0  
```

Visit http://localhost:8080