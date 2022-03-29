package br.com.lpr.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import br.com.lpr.entities.User;
import br.com.lpr.write.repositories.UserWriteRepository;

@Service
//@EnableTransactionManagement
public class UserWriteService {

	@Autowired
	private UserWriteRepository repoistory;

	
	@Transactional("writePlatformTransactionManager")
	public User save(User entity) {
		 return repoistory.save(entity);
	 }
}
