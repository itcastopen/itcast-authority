FROM java:8
LABEL maintainer="研究院研发组 <research-maint@itcast.cn>"
ARG PACKAGE_PATH
ARG EXPOSE_PORT
ADD ${PACKAGE_PATH:-./} ~/app.jar
EXPOSE ${EXPOSE_PORT}
ENTRYPOINT ["java","-Xmx1024m","-jar","~/app.jar"]
