package br.com.lpr.write.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lpr.entities.User;

public interface UserWriteRepository  extends JpaRepository<User, Integer> {
	
	
}