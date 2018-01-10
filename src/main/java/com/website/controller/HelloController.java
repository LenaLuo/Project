package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.website.properties.GirlProperties;
@SpringBootApplication
@Controller
public class HelloController {
	
	@Autowired
	private GirlProperties girlProperties;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET) //value = "/hello", method = RequestMethod.GET
    @ResponseBody
    public String say(@RequestParam(value="id", required=false, defaultValue="0") Integer id) {
    	//return cupSize + age;
    	//return girlProperties.getCupSize() + girlProperties.getAge();
    	return "id" + id;
    }
}
