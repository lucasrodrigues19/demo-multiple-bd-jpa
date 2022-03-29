package br.com.lpr.read.persistence.main;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

@NoRepositoryBean
public interface IReadMainPersistence<T,ID> extends JpaRepository<T, ID> {

	@Override
	default <S extends T> S save(S entity) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default long count() {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default void deleteById(ID id) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default void delete(T entity) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default void deleteAllById(Iterable<? extends ID> ids) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default void deleteAll(Iterable<? extends T> entities) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default void deleteAll() {
		throw new RuntimeException("Apenas Leitura");
	}


	@Override
	default <S extends T> List<S> saveAll(Iterable<S> entities) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default <S extends T> S saveAndFlush(S entity) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default void deleteAllInBatch(Iterable<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteAllByIdInBatch(Iterable<ID> ids) {
		throw new RuntimeException("Apenas Leitura");
	}

	@Override
	default void deleteAllInBatch() {
		throw new RuntimeException("Apenas Leitura");
	}


}
