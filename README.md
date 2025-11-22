# 项目依赖与版本说明

本项目基于 [ruoyi-vue-plus](https://gitee.com/dromara/ruoyi-vue-plus) 框架，版本为 **5.5.1**。

## 1. 主要依赖版本

| 依赖名称                        | 版本号           | 说明                       |
| ------------------------------- | ---------------- | -------------------------- |
| Spring Boot                     | 3.5.7            | 主体框架                   |
| ruoyi-vue-plus                  | 5.5.1            | 项目基础框架               |
| MyBatis-Plus                    | 3.5.5            | ORM 框架                   |
| MyBatis-Plus Jsqlparser         | 3.5.5            | SQL 解析                   |
| MyBatis-Plus Annotation         | 3.5.5            | 注解支持                   |
| p6spy                          | 3.9.1            | SQL 性能分析插件           |
| AWS SDK for Java (S3)           | 2.20.66          | 对象存储                   |
| jackson-databind                | 2.16.2           | JSON 处理                  |
| springdoc-openapi-starter-webmvc-api | 2.5.0      | OpenAPI 文档               |
| fastexcel                       | 0.12.7           | Excel 处理                 |
| sms4j-spring-boot-starter       | 2.6.1            | 短信服务                   |
| bcprov-jdk15to18                | 1.77             | 加解密支持                 |
| JustAuth                        | 1.16.7           | 第三方登录                 |
| redisson                        | 3.27.2           | Redis 客户端               |
| snail-job-client                | 2.0.0            | 分布式任务调度             |

> 具体版本号以 [pom.xml](pom.xml) 及各子模块 `pom.xml` 配置为准。

## 2. 依赖分布（部分）

- **szx-common-core**：Spring 基础依赖、工具类等
- **szx-common-json**：Jackson 相关依赖
- **szx-common-doc**：OpenAPI 文档
- **szx-common-excel**：Excel 处理
- **szx-common-encrypt**：加解密相关
- **szx-common-idempotent**：幂等支持
- **szx-common-job**：定时任务与 SnailJob
- **szx-common-log**：日志与安全
- **szx-common-mail**：邮件发送
- **szx-common-mybatis**：MyBatis-Plus 相关
- **szx-common-oss**：对象存储
- **szx-common-redis**：Redis 支持
- **szx-common-ratelimiter**：限流
- **szx-common-satoken**：权限认证
- **szx-common-sensitive**：脱敏
- **szx-common-sms**：短信
- **szx-common-social**：第三方登录
- **szx-common-sse**：服务端推送
- **szx-common-translation**：通用翻译
- **szx-common-web**：Web 支持
- **szx-common-websocket**：WebSocket 支持

## 3. 版本管理

- 统一版本号通过根目录 [pom.xml](pom.xml) `<properties>` 标签管理，核心版本号如 `revision`、`spring-boot.version`、`mybatis-plus.version` 等均集中定义，便于维护和升级。

## 4. 说明

- 所有子模块均继承自父模块，版本号通过 `${revision}` 变量统一管理。
- 依赖管理采用 BOM 方式，见 [szx-common-bom/pom.xml](szx-common/szx-common-bom/pom.xml)。
- 具体依赖请参考各模块下的 `pom.xml` 文件。

---

如需详细依赖树，可在项目根目录执行：

```sh
mvn dependency:tree
