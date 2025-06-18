- container는 한 개의 프로세스이므로 container내에 저장된 데이터는 container 실행 중에만 유지되고 container 삭제시 데이터도 같이 삭제됨 따라서 container 삭제 후에도 데이터를 유지하고자 한다면 볼륨을 생성하면됨 container 실행 초기 부터 host의 데이터를 불러와 사용할 수 있음

방법1. volume생성 후 container 실행하면서 연결하기 - docker volume create volume이름 (* 경로가 자동으로 설정됨) 방법2. container 실행시 option을 통해 내부 volume이용하기 - docker run -v host경로:container 경로 이미지명 (* 자동으로 volume이 생성됨)

 
docker run -d \
> --name mysql-container \
> -p 3306:3306 \
> -v ~/mysql:etc/mysql/conf.d \
> -v mysql-vol/var/lib/mysql \
> -e MYSQL_ROOT_PASWORD=1234 \
