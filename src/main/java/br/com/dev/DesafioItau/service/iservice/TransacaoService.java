package br.com.dev.DesafioItau.service.iservice;

import br.com.dev.DesafioItau.domain.dto.EstatisticaDTO;
import br.com.dev.DesafioItau.domain.dto.TransacaoDTO;

public interface TransacaoService {

    void salvarTransacao(TransacaoDTO transacaoDTO);
    void deletarTransacoes();
    EstatisticaDTO calcularEstatisticas();

}
