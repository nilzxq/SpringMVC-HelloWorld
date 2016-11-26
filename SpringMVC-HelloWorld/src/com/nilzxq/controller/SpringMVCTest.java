package com.nilzxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nilzxq.entity.UserEntity;
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	/**
	 * 常量大写
	 */
	private static final String SUCCESS="success";
	/**
	 * springmvc会按请求参数名和POJO属性名进行自动匹配为该填充对象的属性值
	 * 支持级联属性
	 * @param user
	 * @return 
	 * 2016年11月26日
	 */
	@RequestMapping("/testPojo")
	private String testPojo(UserEntity user){
		System.out.println("this is testPojo user:"+user.toString());
		return SUCCESS;
	}
	/**
	 * 通过@RequestParam 可以绑定请求传入参数 required默认为true 参数必须要传入false 参数可以不传入defaultValue 设置默认值
	 * @param username
	 * @param age
	 * @return 
	 * 2016年11月26日
	 */
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam("username")String username,@RequestParam(value="age",required=false,defaultValue="18")Integer age){
		System.out.println("this is testRequestParam username="+username+"---age="+age);
		return SUCCESS;
	}
	//@PathVariable("id")||@PathVariable
	/**
	 * @PathVariable可以将URL中占位参数绑定到控制器处方法入参中
	 * @param id
	 * @return 
	 * 2016年11月26日
	 */
	@RequestMapping(value="/order/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id")Integer id){
		System.out.println("删除操作：id="+id);
		return SUCCESS;
	}
	@RequestMapping(value="/order/{id}",method=RequestMethod.GET)
	public String get(@PathVariable("id")Integer id){
		System.out.println("获取资源操作：id="+id);
		return SUCCESS;
	}
	@RequestMapping(value="/order/{id}",method=RequestMethod.POST)
	public String post(@PathVariable("id")Integer id){
		System.out.println("添加操作：id="+id);
		return SUCCESS;
	}
	@RequestMapping(value="/order/{id}",method=RequestMethod.PUT)
	public String put(@PathVariable("id")Integer id){
		System.out.println("更新操作：id="+id);
		return SUCCESS;
	}
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id")Integer id){
		System.out.println("this is id="+id);
		System.out.println("this is testPathVariable");
		return SUCCESS;
	}
	
	@RequestMapping("/*/testAnt")
	public String testAnt(){
		System.out.println("this is testAnt");
		return SUCCESS;
	}
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
