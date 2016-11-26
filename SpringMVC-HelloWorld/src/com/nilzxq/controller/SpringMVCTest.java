package com.nilzxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	/**
	 * 常量大写
	 */
	private static final String SUCCESS="success";
	@RequestMapping(value="/testParams",params={"userName","age!=10"})
	public String testParams(){
		System.out.println("this is testParams");
		return SUCCESS;
	}
	/**
	 * method 主要设置请求方式
	 * @return 
	 * 2016年11月26日
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("this is a testMethod");
		return SUCCESS;
		
	}
	/**
	 * 不仅可以修饰方法，也可以修饰类
	 * 1. @RequestMapping 除了修饰方法, 还可来修饰类
	 * 2.
	 *  1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录
	 *  2). 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。
	 *      若类定义处未标注 @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录
	 * @return 
	 * 2016年11月26日
	 */
	@RequestMapping("/springMVCTest")
	public String springMVCTest(){
		System.out.println("This is a springMVCTest");
		return SUCCESS;
	}

}
