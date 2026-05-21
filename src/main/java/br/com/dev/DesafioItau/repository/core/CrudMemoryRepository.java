package br.com.dev.DesafioItau.repository.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class CrudMemoryRepository<T, ID> implements CrudMemoryRepositoryInterface<T, ID> {

    private Map<ID, T> database = new HashMap<>();

    protected abstract ID getId(T entity);

    @Override
    public T save(T entity) {
        ID id = getId(entity);
        database.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public void deleteById(ID id) {
        database.remove(id);
    }

    @Override
    public void deleteAll() {
        database.clear();
    }

}
