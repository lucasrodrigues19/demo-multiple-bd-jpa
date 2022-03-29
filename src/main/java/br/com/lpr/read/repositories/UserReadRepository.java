package br.com.lpr.read.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.lpr.entities.User;
import br.com.lpr.read.persistence.IUseReadPersistence;

@Component("userReadRepository")
@Primary
public class UserReadRepository implements IReadRepository<User,Integer> {

	@Autowired
	private  IUseReadPersistence persistence;
	

	@Override
	public List<User> findAll() {
		return persistence.findAll();
	}

	@Override
	public User findById(Integer id) {
		return persistence.findById(id).orElse(new User());
	}
	
	
	
	
}