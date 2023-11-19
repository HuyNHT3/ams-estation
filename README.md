# ams-estation
mec-be, this is used for authentication and authorization 
* java >= 17
  -run app: mvn spring-boot:run
* build docker
  - Build image: 
		 docker build --tag java-docker .
  - Run (if it has error when run ./mvnw): 
		 sed -i 's/\r$//' mvnw
