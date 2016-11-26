package com.nilzxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 表示为 springmvc控制器
 * @author zxq @date 2016年11月26日
 *
 */
@Controller
public class HelloWorld {
	/**
	 * 控制器类中方法上加入该注解@RequestMapping 为请求路径
	 * @return 
	 * 2016年11月26日
	 */
	@RequestMapping("/test")
	public String test(){
		System.out.println("this is a test!");
		return "success";
	}

}
