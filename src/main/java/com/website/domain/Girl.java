package com.website.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;






@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Min(value = 18, message="未成年请绕道")
	private Integer age;
	private String cupSize;
	
	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	
	public Girl(){}
	
	@Override
	public String toString(){
		return "Girl{" +
					"id=" +id+
					", cupSize='" + cupSize + '\'' +
					", age=" + age +
					'}';
	}
	
}
