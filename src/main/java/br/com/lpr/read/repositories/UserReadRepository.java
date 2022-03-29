package br.com.lpr.read.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lpr.entities.User;

public interface UserReadRepository  extends JpaRepository<User, Integer> {

	
}