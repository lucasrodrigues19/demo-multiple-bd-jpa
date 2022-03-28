package br.com.lpr.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lpr.entities.user.User;

public interface UserRepository extends JpaRepository<User, Integer> { }