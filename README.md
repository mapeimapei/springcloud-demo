# springcloud-demo


### 这个自习项目的主要目的是搭建一个springCloud微服务架构，将之前用springBoot写小项目（https://github.com/mapeimapei/springBoot_myBatis_shiro）拆分为微服务模式，进而学习和熟悉springCloud。

### 主要用到的组件有Eureka、OpenFeign、Hystrix、Zuul。

### 微服务如下：
project-api：公共微服务
project-eureka-7001：Eureka微服务
project-eureka-7002：Eureka微服务
project-zuul-gateway-9501:网关微服务
project-provider-user-8001：用户中心微服务
project-provider-blog-8002：博客微服务
project-provider-shop-8003：商店微服务
project-web-80：web消费端微服务

### 由于仅仅是框架的搭建和之前项目的拆分，所以整个项目仅历时13天，比较顺利。

### 由于计划和时间的原因，还有很多组件没有用到，比如Ribbon、bus、Config、Oauth。

### 从前端看起来和5月份用springBoot写的项目没有任何区别，但代码组织，逻辑和实现方案都已有很多不同。

### 它已初步具备超级母体的功能，后边随着学习和技术的进步，功能肯定会越来越完善强大。


###  这个项目的git地址如下，喜欢可以拿去：
https://github.com/mapeimapei/springcloud-demo
