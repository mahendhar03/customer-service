FROM ubuntu
ARG WORKSPACE
RUN apt update -y
RUN apt install -y openjdk-8-jre
RUN mkdir -p /u01/data
COPY $WORKSPACE/target/customer-service-0.0.1-SNAPSHOT.jar /u01/data
RUN chmod -R 777 /u01
ENTRYPOINT ["java","-jar","/u01/data/customer-service-0.0.1-SNAPSHOT.jar"]
