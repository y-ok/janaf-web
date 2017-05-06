# Janaf-web

## How to use

- step0

```
$ docker-machine create --driver virtualbox development
$ docker-machine regenerate-certs development
$ eval "$(docker-machine env development)"
$ docker-machine start development

```

- step1

```cmd
$ git clone https://github.com/y-ok/janaf-web.git
$ cd janaf-web
$ mvn clean package -Dmaven.test.skip=true
```

- step2

```cmd
$docker build -t y-ok/janaf-web .
```

- step3

```cmd
$docker-compose up product
```

- step4

http://localhost:8080/elements

- Stopping janaf-web

```cmd
$ docker-compose down
```