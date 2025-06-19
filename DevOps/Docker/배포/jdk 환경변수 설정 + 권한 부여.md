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
