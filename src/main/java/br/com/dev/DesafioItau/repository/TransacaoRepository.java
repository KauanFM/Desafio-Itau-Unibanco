package br.com.dev.DesafioItau.repository;

import org.springframework.stereotype.Repository;

import br.com.dev.DesafioItau.domain.core.Transacao;
import br.com.dev.DesafioItau.repository.core.CrudMemoryRepository;

@Repository
public class TransacaoRepository extends CrudMemoryRepository<Transacao, Integer> {

    @Override
    protected Integer getId(Transacao entity) {
        return entity.getId();
    }

}
