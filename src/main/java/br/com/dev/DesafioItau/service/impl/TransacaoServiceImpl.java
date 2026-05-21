package br.com.dev.DesafioItau.service.impl;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dev.DesafioItau.domain.core.Transacao;
import br.com.dev.DesafioItau.domain.dto.EstatisticaDTO;
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

    @Override
    public EstatisticaDTO calcularEstatisticas() {

        List<Transacao> transacoes = transacaoRepository.findAll();

        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);

        DoubleSummaryStatistics estatisticas = transacoes.stream()
                .filter(t -> !t.getDataHora().isBefore(limite))
                .map(Transacao::getValor)
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
        
        if (estatisticas.getCount() == 0) {
            estatisticaDTO.setCount(0);
            estatisticaDTO.setSum(0.0);
            estatisticaDTO.setAvg(0.0);
            estatisticaDTO.setMin(0.0);
            estatisticaDTO.setMax(0.0);
            return estatisticaDTO;
        }

        return EstatisticaDTO.builder()
                .count(((int) estatisticas.getCount()))
                .sum(estatisticas.getSum())
                .avg(estatisticas.getAverage())
                .min(estatisticas.getMin())
                .max(estatisticas.getMax())
                .build();
    }

}
