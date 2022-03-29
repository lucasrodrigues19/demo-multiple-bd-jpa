package br.com.lpr.write.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.lpr.entities.User;
import br.com.lpr.write.persistence.IUseWritePersistence;

@Component("userWriteRepository")
@Primary
public class UserWriteRepository implements IWriteRepository<User> {
	
	@Autowired
	private IUseWritePersistence persistence;
	
	@Override
	public User save(User entity) {
		return persistence.save(entity);
	} 
	
	
}