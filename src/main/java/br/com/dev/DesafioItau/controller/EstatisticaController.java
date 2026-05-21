package br.com.dev.DesafioItau.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.DesafioItau.domain.dto.EstatisticaDTO;
import br.com.dev.DesafioItau.service.iservice.TransacaoService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final TransacaoService transacaoService;

    public EstatisticaController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public EstatisticaDTO listarEstatisticas() {
        return transacaoService.calcularEstatisticas();
    }
    

}
