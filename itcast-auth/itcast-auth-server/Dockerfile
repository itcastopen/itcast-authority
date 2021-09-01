FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 18510971002@163.com

RUN mkdir -p /itcast/auth

WORKDIR /itcast/auth

EXPOSE 8764

ADD ./target/itcast-auth-server.jar ./app.jar

ENTRYPOINT ["java","-Xms256m","-Xmx256m","-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=prod"]
