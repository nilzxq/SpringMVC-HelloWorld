package com.nilzxq.entity;

public class UserEntity {
  private String userName;
  private Integer age;
  private AddressEntity address;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public AddressEntity getAddress() {
	return address;
}
public void setAddress(AddressEntity address) {
	this.address = address;
}
@Override
public String toString() {
	return "UserEntity [userName=" + userName + ", age=" + age + ", address.getCity()="
			+ address.getCity() + "]";
} 
  
}
