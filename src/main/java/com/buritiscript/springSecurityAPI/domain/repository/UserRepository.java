package com.buritiscript.springSecurityAPI.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buritiscript.springSecurityAPI.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
