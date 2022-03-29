package br.com.lpr.write.repositories;

public interface IWriteRepository<E> {

	public E save(E entity);
	
}
