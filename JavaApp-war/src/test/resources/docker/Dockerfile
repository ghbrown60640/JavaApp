FROM ubuntu
ENV DEBIAN_FRONTEND noninteractive
RUN apt-get install -y dialog
RUN apt-get update
RUN apt-get upgrade
RUN apt-get -y install  tomcat7 tomcat7-admin
RUN apt-get -y install   tomcat7-admin
RUN apt-get -y install   tomcat7-user
ADD ./tomcat-users.xml /etc/tomcat7/tomcat-users.xml
VOLUME ["/data"]
EXPOSE 8080
CMD service tomcat7 start && tail -f /var/lib/tomcat7/logs/catalina.out
