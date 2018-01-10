package com.website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.domain.Girl;



public interface GirlRepository extends JpaRepository<Girl, Integer>{

	public List<Girl> findByAge(String age);
}
