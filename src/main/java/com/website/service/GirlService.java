package com.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.domain.Girl;
import com.website.enums.ResultEnum;
import com.website.exception.GirlException;
import com.website.repository.GirlRepository;

@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void inserTwo(){
		Girl girlA = new Girl();
		girlA.setAge(18);
		girlA.setCupSize("A");
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setAge(18);
		girlB.setCupSize("BBBB");
		girlRepository.save(girlB);
	}
	
	public void getAge(Integer id) throws Exception{
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		
		if(age <= 10){
			//返回"你还在上小学吧"
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age >10 && age<16){
			//返回"你可能在上初中"
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
				
	}
}
