FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 18510971002@163.com

RUN mkdir -p /itcast/gateway

WORKDIR /itcast/gateway

EXPOSE 8760

ADD ./target/itcast-gateway.jar ./app.jar

ENTRYPOINT ["java","-Xms256m","-Xmx256m","-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=prod"]
