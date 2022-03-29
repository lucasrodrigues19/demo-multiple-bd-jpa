package br.com.lpr.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lpr.entities.User;
import br.com.lpr.read.repositories.UserReadRepository;

@Service
//@EnableTransactionManagement
public class UserReadService {

	@Autowired
	private UserReadRepository repoistory;

	
	@Transactional("readPlatformTransactionManager")
	public List<User> findAll() {
		 return repoistory.findAll();
	 }
}
