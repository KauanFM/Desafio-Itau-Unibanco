package br.com.dev.DesafioItau.service.impl;

import org.springframework.stereotype.Service;

import br.com.dev.DesafioItau.domain.core.Transacao;
import br.com.dev.DesafioItau.domain.dto.TransacaoDTO;
import br.com.dev.DesafioItau.repository.TransacaoRepository;
import br.com.dev.DesafioItau.service.iservice.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {
    
    private final TransacaoRepository transacaoRepository;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }


    @Override
    public void salvarTransacao(TransacaoDTO transacaoDTO) {

        Transacao transacao = Transacao.builder()
                .valor(transacaoDTO.getValor())
                .dataHora(transacaoDTO.getDataHora())
                .build();

        transacaoRepository.save(transacao);
        
    }

    @Override
    public void deletarTransacoes() {
        transacaoRepository.deleteAll();
    }

}
