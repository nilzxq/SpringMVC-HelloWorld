package com.nilzxq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nilzxq.entity.AddressEntity;
@RequestMapping("/SpringMVCJSONTest")
@Controller
public class SpringMVCJSONTest {

	/**
    * 需求：需要接口提供所有的城市，并且城市一定要是JSON数值的[{"city":"上海"},{"city":"北京"}]
    */
	@ResponseBody
	@RequestMapping("/getListAddress")
    public List<AddressEntity> getListAddress(){
    	AddressEntity addressEntity=new AddressEntity("上海");
    	AddressEntity addressEntity1=new AddressEntity("北京");
    	AddressEntity addressEntity2=new AddressEntity("武汉");
    	AddressEntity addressEntity3=new AddressEntity("孝感");
    	List<AddressEntity> listAddress=new ArrayList<AddressEntity>();
    	listAddress.add(addressEntity);
    	listAddress.add(addressEntity1);
    	listAddress.add(addressEntity2);
    	listAddress.add(addressEntity3);
		return listAddress;
    }
	/**
	 * {"city":"北京"}
	 */
	@ResponseBody
	@RequestMapping("/getAddressEntity")
	public AddressEntity getAddressEntity(){
		AddressEntity addressEntity=new AddressEntity("上海");
		return addressEntity;
	}
}
