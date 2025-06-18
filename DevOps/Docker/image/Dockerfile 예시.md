```
# FROM : 베이스 이미지로 ubuntu지정 
FROM ubuntu:latest 
# CMD : 해당 파일로 빌드된 이미지로 컨테이너 실행시 수행할 명령어 
# 수행 내용 : ubuntu의 echo 명령어로 특정 구문 출력   
CMD ["echo", "hello dockerfile"] 
```

```
# FROM : 베이스 이미지로 ubuntu지정 
FROM ubuntu:latest 
# ARG : 해당 파일을 이미지로 빌드시 전달되는 값을 받기 위한 변수 
# 빌드시 BUILD_MSG로 전달값 받을 예정
ARG BUILD_MSG
# RUN : 해당 파일을 통해 "이미지로 빌드시" 수행할 명령어 (빌드시 전달받은값 출력해보기)
RUN echo image building content $BUILD_MSG 
# CMD : 해당 파일로 빌드된 이미지로 "컨테이너 실행시" 수행할 명령어 
# 수행 내용 : ubuntu의 echo 명령어로 특정 구문 출력   (빌드시 전달받은값 출력해보기)
CMD echo container running content $BUILD_MSG 
```


```
# FROM : 베이스 이미지로 ubuntu지정 
FROM ubuntu:latest 
# ARG : 해당 파일을 이미지로 빌드시 전달되는 값을 받기 위한 변수 
# 빌드시 BUILD_MSG, CONATINER_MSG로 전달값 받을 예정
ARG BUILD_MSG
ARG CONTAINER_MSG
# ENV : 환경변수로 설정하고자 하는 변수 설정
ENV CONTAINER_MSG_ENV=${CONTAINER_MSG}
# RUN : 해당 파일을 통해 이미지로 빌드시 수행할 명령어 (빌드시 전달받은값 출력해보기)
RUN echo image building content $BUILD_MSG 
# ENTRYPOINT : CMD와 동일하나 보통 컨테이너 실행시 반드시 수행시킬 기본명령어를 작성
# 수행 내용 : ubuntu의 echo 명령어로 특정 구문 출력   (빌드시 전달받은값 출력해보기)
ENTRYPOINT echo container running content $BUILD_MSG $CONTAINER_MSG_ENV
```

- javaDirDocker
```
# FROM : 베이스 이미지로 ubuntu지정 
FROM ubuntu:latest 
# RUN : 해당 파일을 통해 이미지로 빌드시 수행할 명령어
# 수행 내용 : 패키지 관리자를 이용하여 자바 설치
RUN apt-get update && apt-get install -y openjdk-17-jdk
# ENV : 환경변수로 설정하고자 하는 변수 설정
ENV DEFAULT_PATH="/home/javatest" \
    JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
# WORKDIR : 컨테이너가 사용할 기본 작업 폴더 지정
WORKDIR $DEFAULT_PATH
```

- addcopyDockerfile
```
# FROM : 베이스 이미지로 ubuntu지정 
FROM ubuntu:latest
# RUN : 해당 파일을 통해 이미지로 빌드시 수행할 명령어 
# 수행 내용 : 패키지관리도구로 자바, git, gradle, unzip 설치
RUN apt-get update && apt-get install -y openjdk-17-jdk git gradle unzip

# ADD : HOST파일을 이미지안으로 복사 (로컬파일+git외부파일도 가능, 압축해제 기본적으로 제공하나 외부파일은 안됨)
# 수행 내용 : 아래의 git URL의 dockersample.zip 파일을 복사 (압축해제 안됨)
ADD https://github.com/boramkang/dockersample/blob/main/test/dockerfile_sample.zip /home/addtest/
# 수행 내용 : HOST내의 apache-tomcat-9.0.89.tar.gz 파일을 복사 (압축해제 됨)
ADD apache-tomcat-9.0.89.tar.gz /home/tomcat/

# COPY : HOST파일을 이미지안으로 복사 (로컬파일만 가능, 압축해제안됨)
# 수행 내용 : HOST내의 index.html 파일을 복사
COPY index.html /home/tomcat/apache-tomcat-9.0.89/webapps/ROOT/
# 수행 내용 : HOST내의 apache-tomcat-9.0.89.tar.gz 파일을 복사 (압축해제안됨)
COPY apache-tomcat-9.0.89.tar.gz /home/copytest/
```

- finaklDockerfile
```
# FROM : 베이스 패키지로 ubuntu지정 
FROM ubuntu:latest 
# LABEL : 해당 이미지의 목적, 버전, 타이틀, 설명 등을 작성 
LABEL maintainer="boramkang <teacherboram@gmail.com>" \
      name="boramkang" \
      title="boram server" \
      description="build tomcat and start server"

# RUN : 해당 파일을 통해 이미지로 빌드시 수행할 명령어
# 수행 내용 : 패키지 관리자 도구로 자바, wget 설치
RUN apt-get update && apt-get install -y openjdk-17-jdk vim wget
# 수행 내용 : wget을 이용하여 톰캣 tar파일 url통해 다운받기
RUN wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.89/bin/apache-tomcat-9.0.89.tar.gz -P /home/tomcat/
# 수행 내용 : tar 명령어를 이용하여 다운받은 tar파일 압축해제하기
RUN tar -xf /home/tomcat/apache-tomcat-9.0.89.tar.gz -C /home/tomcat/

# COPY : HOST파일을 이미지안으로 복사 
# 수행 내용 : HOST내의 index.html 파일을 복사
COPY index.html /home/tomcat/apache-tomcat-9.0.89/webapps/ROOT/

# ENV : 환경변수로 설정하고자 하는 변수 설정
ENV JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"

# ENTRYPOINT|CMD : 컨테이너 실행시 수행시킬 명령어 작성
# 수행 내용 : 컨테이너 내에 설치된 톰캣을 바로 start 시키기
ENTRYPOINT ["/home/tomcat/apache-tomcat-9.0.89/bin/catalina.sh"]
CMD ["run"]
```

