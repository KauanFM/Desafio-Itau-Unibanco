package br.com.dev.DesafioItau.repository.core;

import java.util.List;
import java.util.Optional;

public interface CrudMemoryRepositoryInterface<T, ID> {

    T save(T entity);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    void deleteAll();

    List<T> findAll();

}
