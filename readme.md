# Read Me First
项目在IDEA下测试运行正常。

由于querydsl需要根据实体动态生成以Q打头的映射类，所以此项目不能够直接运行。

在运行以前需要经过以下两步：
1. 执行mvn install
2. 在pom.xml上点击右键 --> maven --> Generate Sources and Update Folders 

本项目对应文章地址：http://www.codedemo.club/querydsl-with-jpa-tutorial/

The following was discovered as part of building this project:

* The original package name 'club.codedemo.querydsl-with-jpa-tutorial' is invalid and this project uses 'club.codedemo.querydslwithjpatutorial' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

