package br.com.dev.DesafioItau.repository;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import br.com.dev.DesafioItau.domain.core.Transacao;
import br.com.dev.DesafioItau.repository.core.AbstractCrudMemoryRepository;

@Repository
public class TransacaoRepository extends AbstractCrudMemoryRepository<Transacao, Long> {

    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    protected Long getId(Transacao entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Transacao entity, Long id) {
        entity.setId(id);
    }

    @Override
    protected Long generateId() {
        return idGenerator.incrementAndGet();
    }

}
