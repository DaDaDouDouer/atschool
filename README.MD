# 二手书交易系统
<!-- toc -->

* [二手书交易系统](#二手书交易系统)
	* [后台配置文件注意事项](#后台配置文件注意事项)
	* [运行项目](#运行项目)

<!-- tocstop -->
## 后台配置文件注意事项

1. mybatis-config.xml需要添加所有要入库的bean

2. mapper需要根据dao修改，且mapper中语句的id必须和dao中接口方法的名字一致

3. jdbc.properties依个人情况酌量修改，其他配置文件暂时不需要改动

## 运行项目

1. 如果出现log4j的报错，找不到文件WEB-INF/logs/error.log，则不用管

2. 项目运行后，context为**reusebook**，后面的接口路径取决于controller中的路径写法，最后以.do结尾。
形如：http://localhost:8080/reusebook/selectAll.do

3.
