package com.nilzxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ��ʾΪspringmvc������
 * @author zxq @date 2016��11��26��
 *
 */
@Controller
public class HelloWorld {
	/**
	 * ���������з����ϼ����ע��@RequestMappingΪ����·��
	 * @return 
	 * 2016��11��26��
	 */
	@RequestMapping("/test")
	public String test(){
		System.out.println("this is a test!");
		return "success";
	}

}
