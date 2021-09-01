# 1 权限管家

## 1.1 环境安装：

`本次环境安装使用docker方式部署`

### 1.1.1 安装nacos

```shell
# 安装nacos
docker run --env MODE=standalone --name nacos -d -p 8848:8848 nacos/nacos-server
# 查看日志
docker logs -f nacos
```

测试 地址：http://localhost:8848/nacos    用户名：nacos   密码：nacos

![image-20210830152232691](install.assets/image-20210830152232691.png)

### 1.1.2 安装mysql

```shell
# 安装mysql
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d -i -p 3306:3306 mysql:latest
# 查看日志
docker logs -f mysql
```

测试（使用navcat）  Host：localhost    Port：3306    User Name：root    Password：123456

![image-20210830152548433](install.assets/image-20210830152548433.png)

录入信息后 点击【Test Connection】按钮，弹出‘Successful’ 字样表示成功

![image-20210830152631400](install.assets/image-20210830152631400.png)

### 1.1.3 安装redis

```shell
# 安装redis
docker run -p 6379:6379 --name redis -d redis 
# 查看日志
docker logs -f redis
```

测试（使用Redis Desktop Manager） Address：127.0.0.1

![image-20210830153224315](install.assets/image-20210830153224315.png)

录入信息后 点击【Test Connection】按钮，弹出‘Successful’ 字样表示成功

![image-20210830153242575](install.assets/image-20210830153242575.png)

## 1.2 数据导入

### 1.2.1 nacos配置导入

#### 1.2.1.1 创建命名空间

![image-20210830154104472](install.assets/image-20210830154104472.png)

录入 信息，如下图：

- 命名空间名：itcast-authority
- 描述：权限管家

![image-20210830154200988](install.assets/image-20210830154200988.png)

#### 1.2.1.2 导入配置

![image-20210830154326764](install.assets/image-20210830154326764.png)

选择文件  项目根目录：docs/naocs/nacos_config_export_.zip

![image-20210830154504033](install.assets/image-20210830154504033.png)

![image-20210830154525067](install.assets/image-20210830154525067.png)


### 1.2.2 mysql数据导入

#### 1.2.2.1 创建数据库

<img src="install.assets/image-20210830155103917.png" alt="image-20210830155103917" style="zoom:50%;" /> 

<img src="install.assets/image-20210830154953700.png" alt="image-20210830154953700" style="zoom:50%;" /> 

#### 1.2.2.2 导入数据库脚本

<img src="install.assets/image-20210830155258853.png" alt="image-20210830155258853" style="zoom:50%;" /> 

选择文件 项目根目录：docs/mysql/itcast_auth.sql

<img src="install.assets/image-20210830155526072.png" alt="image-20210830155526072" style="zoom:50%;" /> 

<img src="install.assets/image-20210830155651916.png" alt="image-20210830155651916" style="zoom:50%;" /> 

## 1.3 项目启动

### 1.3.1 修改根pom文件

修改pom中的namespace

![image-20210830161742463](install.assets/image-20210830161742463.png)

namespace 为1.2.1.1 章节中创建 

![image-20210830162147892](install.assets/image-20210830162147892.png)

### 1.3.2 编译工程

```shell
mvn clean install -DskipTests
```

![image-20210830162328668](install.assets/image-20210830162328668.png)

### 1.3.3 启动服务

先启动 AuthorityApplication 然后启动GatewayServerApplication

![image-20210830162505668](install.assets/image-20210830162505668.png)

启动成功 点击Swagger文档 选择一个接口测试服务是否正常返回

![image-20210830163402242](install.assets/image-20210830163402242.png)

![image-20210830164827769](install.assets/image-20210830164827769.png)

