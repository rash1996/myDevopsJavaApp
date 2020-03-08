FROM ubuntu:16.04
WORKDIR /opt/java
ADD jdk-11.0.2_linux-x64_bin.tar.gz .
ENV JAVA_HOME=/opt/java/jdk-11.0.2
ENV PATH $JAVA_HOME/bin:$PATH
WORKDIR /opt/tomcat
ADD apache-tomcat-8.5.27.tar.gz .
COPY ProteinStore.war /opt/tomcat/apache-tomcat-8.5.27/webapps/
EXPOSE 8080
CMD ["/opt/tomcat/apache-tomcat-8.5.27/bin/catalina.sh" , "run"]



