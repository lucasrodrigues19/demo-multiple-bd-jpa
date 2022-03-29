package br.com.lpr.write.persistence.main;

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
public interface IWriteMainPersistence<T,ID> extends JpaRepository<T, ID> {

	@Override
	default <S extends T> Optional<S> findOne(Example<S> example) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default <S extends T> long count(Example<S> example) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default <S extends T> boolean exists(Example<S> example) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default <S extends T, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default Page<T> findAll(Pageable pageable) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default Optional<T> findById(ID id) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default boolean existsById(ID id) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default long count() {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default void deleteById(ID id) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default void delete(T entity) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default void deleteAllById(Iterable<? extends ID> ids) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default void deleteAll(Iterable<? extends T> entities) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default void deleteAll() {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default List<T> findAll() {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default List<T> findAll(Sort sort) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default List<T> findAllById(Iterable<ID> ids) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default T getOne(ID id) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default T getById(ID id) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default <S extends T> List<S> findAll(Example<S> example) {
		throw new RuntimeException("Apenas Escrita");
	}

	@Override
	default <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		throw new RuntimeException("Apenas Escrita");
	}

}
