# SpringMVC-HelloWorld
<h1>springmvc基础回顾</h1>
<h2>内容概述</h2>
1.SpringMVC 概述<br>
2.SpringMVC  HelloWorld <br/>
3.使 @RequestMapping 映射请求 <br/>
4.映射请求参数 & 请求头 <br/>
5.模型数据 <br/>
6.视图和视图解析器 <br/>
7.restful CRUD <br/>
8.SpringMVC  单标签 &处理静态态资源 <br/>
9.数据转换 & 数据格式化 & 数据校验 <br/>
10.使用JSON  HttpMessageConverter <br/>
11.文件上传 <br/>
12.使用截器  <br/>
13.异常处理<br/>

<h2>SpringMVC概述</h2>
Spring mvc为 展现层 提供基于 MVC 设计理念
Spring3.0 后全 Struts2成 为 最 优 MVC  框架 
Spring MVC  过 一套 MVC  注 让 POJO 成为处理请 
求控制器无法实现任何接口。
支持 restful 规格 URL 请求<br/> 
松散 耦合可插拔组件结构比其他 MVC 框架更具扩展性和灵活性<br/>


疑问：load-on-startup 作用？<br/>
在servlet的配置当中，<load-on-startup>5</load-on-startup>的含义是：
标记容器是否在启动的时候就加载这个servlet。
当值为0或者大于0时，表示容器在应用启动时就加载这个servlet；
当是一个负数时或者没有指定时，则指示容器在该servlet被选择时才加载。
正数的值越小，启动该servlet的优先级越高。<br/>

 如何通过 SpringMVC返回JSON？<br/>
1、在请求方法上加上@ResponseBody,通过返回值类型自动转换JSON<br/>
2、添加Jar包<br/>
jackson-annotations-2.4.1.jar
jackson-core-2.4.1.jar
jackson-databind-2.4.1.jar
jackson-core-asl-1.9.13.jar
jackson-mapper-asl-1.9.13.jar
3、需要在SpringMVC配置文件配置如下信息:<br/>
<!-- 开启注解 -->
<mvc:annotation-driven />
  <!-- 避免IE执行AJAX时,返回JSON出现下载文件 -->
	<bean id="mappingJacksonHttpMessageConverter"
		class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter">
		<property name="supportedMediaTypes">
			<list>
				<value>text/html;charset=UTF-8</value>
			</list>
		</property>
	</bean>

	<!-- 启动Spring MVC的注解功能，完成请求和注解POJO的映射 -->
	<bean
		class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
		<property name="messageConverters">
			<list>
				<ref bean="mappingJacksonHttpMessageConverter" /><!-- json转换器 -->
			</list>
		</property>
	</bean>







SpringMVC文件上传？<br/>
1、SpringMVC配置文件中配置上传文件信息<br/>
<!-- SpringMVC上传文件时，需要配置MultipartResolver处理器 --> 
 <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
<property name="defaultEncoding" value="utf-8" />
<!--1024*200即200k-->  
       <property name="maxUploadSize" value="204800" />
</bean>
2、前端页面实例<br/>

	<form action="upload/" method="post" enctype="multipart/form-data">
		上传文件<input type="file" name="file"> <input type="submit"
			value="提交">
	</form>


3、后端代码实例<br/>

@RequestMapping(value = "/upload", method = RequestMethod.POST)<br/>
public String upload(@RequestParam(value = "file", required = false) MultipartFile file,<br/>
			
			HttpServletRequest request) {
		String path = "c://itmayiedu";
String fileName = file.getOriginalFilename();<br/>
File targetFile = new File(path, fileName);<br/>
if (!targetFile.exists()) {<br/>
targetFile.mkdirs();<br/>
}<br/>
// 保存try {<br/>
file.transferTo(targetFile);<br/>

		} catch (Exception e) {

		}

		return "success";

	}
