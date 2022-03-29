package br.com.lpr.read.repositories;

import java.util.List;

public interface IReadRepository<E,ID> {

	public List<E> findAll();
	
	public E findById(ID id);
}
