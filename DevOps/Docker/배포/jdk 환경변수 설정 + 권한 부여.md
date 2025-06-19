- `apt-get update`
- `apt-get install -y openjdk-17-jdk`

- /root/
- .profile에 아래 추가
```
# JAVA_HOME  
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64  
export PATH=$JAVA_HOME/bin:$PATH
```
- `source ~/.profile`


- cd 프로젝트명
- `chmod +x ./gradlew`

docker run -d \
> --name app-container \
> -p 8080:8080 \
> -e SPRING_PROFILES_ACTIVE=prod \
> -e PROD_DB_URL=jdbc:mysql://211.188.48.119:3306/menudb \
> -e PROD_DB_USERNAME=sotogito \
> -e PROD_DB_PASSWORD=sotogito \
> app-image
