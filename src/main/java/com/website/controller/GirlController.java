/**
 * 
 */
package com.website.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.website.domain.Girl;
import com.website.domain.Result;
import com.website.repository.GirlRepository;
import com.website.service.GirlService;
import com.website.service.utils.ResultUtil;

import java.util.List;

import javax.validation.Valid;

/**
 * @author I317066
 *
 */
@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	@GetMapping(value = "/girls")
	public List<Girl> girlList(){
		return girlRepository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/girls")
	public Result<Object> girlAdd(@Valid Girl girl, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
//			Result<Girl> result1 = new Result<Girl>();
//			result1.setCode(1);
//			result1.setMsg(bindingResult.getFieldError().getDefaultMessage());
//			result1.setData(null);
//			System.out.println(bindingResult.getFieldError().getDefaultMessage());
//			return null;
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		
//		Result<Girl> result = new Result<Girl>();
//		result.setCode(0);
//		result.setMsg("成功");
//		result.setData(girlRepository.save(girl));
		return ResultUtil.success(girlRepository.save(girl));
	}
	
	/*
	 * 查询一个女生
	 * */
	@GetMapping(value = "girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer Id){
		return girlRepository.findOne(Id);
	}
	
	
	//更新
	
	@PutMapping(value = ("/girls/{id}"))
	public Girl girlUpdate(@RequestParam("id") Integer id, 
			@RequestParam("cupSize") String cupSize, 
					@RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		
		return girlRepository.save(girl);
	}
		
	//删除
	
	@DeleteMapping(value = ("/girls/{id}"))
	public void girlDelete(@PathVariable("id") Integer Id){
		 girlRepository.delete(Id);
	}
	
	//通过年龄查询
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") String age ){
		return girlRepository.findByAge(age);
	}
	
	
	@PostMapping(value = "/girls/two")
	public void girlTwo(){
		girlService.inserTwo();
	}
	
	@GetMapping(value = "/girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception{
		girlService.getAge(id);
	}
}
