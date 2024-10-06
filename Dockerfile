FROM image-registry.openshift-image-registry.svc:5000/sample/amazoncorretto-11-0-22:latest
COPY target/*SNAPSHOT.jar /app.jar
EXPOSE 8081
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir /mnt/apps
RUN chmod -R 755 /mnt/apps
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=cloud"]
