# 二手书交易系统

> 二手书交易系统

## 目录
<!-- toc -->

* [二手书交易系统](#二手书交易系统)
  * [目录](#目录)
  * [主要功能模块](#主要功能模块)
  * [技术路线](#技术路线)
    * [前端技术](#前端技术)
    * [后台技术](#后台技术)
  * [环境配置](#环境配置)
    * [前端环境配置](#前端环境配置)
    * [后台环境配置](#后台环境配置)
  * [项目目录结构](#项目目录结构)
  * [后台配置文件注意事项](#后台配置文件注意事项)
  * [运行项目](#运行项目)
    * [前端](#前端)
    * [后台](#后台)

<!-- tocstop -->

## 主要功能模块
1. 书籍展示
    1. 主页推荐书籍展示
    2. 搜索页面书籍展示
    3. 书籍详情页面展示
2. 书籍搜索
    1. 分类搜索
    2. 根据名字模糊搜索
    3. 搜索结果过滤和排序
3. 购物车
    1. 书籍的增删改查
    2. 结算
4. 支付功能
    1. 生成书籍清单
    2. 支付订单
    3. 发货单
5. 个人信息管理
    1. 登录注册
    2. 密码重置
    3. 收货地址管理
6. 评论
7. 后台管理
    1. 订单管理
    2. 用户信息管理

## 技术路线

### 前端技术
    1. vue
    2. vuex
    3. vuetify

### 后台技术

## 环境配置

### 前端环境配置
    1. node

### 后台环境配置

## 项目目录结构

* `src`目录用于放置后台代码

* `www`目录是前端的根目录

## 后台配置文件注意事项

1. mybatis-config.xml需要添加所有要入库的bean

2. mapper需要根据dao修改，且mapper中语句的id必须和dao中接口方法的名字一致

3. jdbc.properties依个人情况酌量修改，其他配置文件暂时不需要改动

## 运行项目

### 前端

具体内容查看`www`文件夹中的，README.md文件

### 后台

#### 环境配置

1. 安装JDK8（推荐8u111及以上），环境变量配置

2. 安装Tomcat（7.0.53），用exe安装则不需要进行环境变量配置

3. 安装maven（3.3.9），环境变量配置。从coding网站下载配置文件，修改本地库路径

4. 项目导入eclipse，导入安装的JRE系统库以及Tomcat库

5.
    修改tomcat的配置文件：server.xml，修改段应该位于该文件的最下方，
    
    修改前：
    ```
        <Context docBase="reusebook" path="/reusebook" reloadable="true" source="org.eclipse.jst.j2ee.server:reusebook"/>
    ```
    修改后：    
    ```
        <Context docBase="reusebook" debug="0" path="" reloadable="true" source="org.eclipse.jst.j2ee.server:reusebook"/>
    ```

    需要注意的是，修改的属性只有docBase，path，之后增加debug属性，别的属性维持原状，比如source以各自的为准

#### 开始运行

1. 如果出现log4j的报错，找不到文件WEB-INF/logs/error.log，则不用管

2. 项目运行后，context为**reusebook**，如果已修改了tomcat的配置文件，则context为空。
    
    context后面的接口路径取决于controller中的路径写法，最后以.do结尾。
    
    形如：http://localhost:8080/reusebook/selectAll.do，http://localhost:8080/selectAll.do

    前端访问方法以前端为准