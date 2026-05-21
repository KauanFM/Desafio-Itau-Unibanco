package br.com.dev.DesafioItau.repository.core;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractCrudMemoryRepository<T, ID> implements CrudMemoryRepositoryInterface<T, ID> {

    private final Map<ID, T> memoryDatabase = new ConcurrentHashMap<>();

    protected abstract ID getId(T entity);

    protected abstract void setId(T entity, ID id);

    protected abstract ID generateId();

    @Override
    public T save(T entity) {
        ID id = getId(entity);
        if (id == null) {
            id = generateId();
            setId(entity, id);
        }
        memoryDatabase.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(memoryDatabase.get(id));
    }

    @Override
    public void deleteById(ID id) {
        memoryDatabase.remove(id);
    }

    @Override
    public void deleteAll() {
        memoryDatabase.clear();
    }

}
