package br.com.dev.DesafioItau.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.dev.DesafioItau.domain.dto.TransacaoDTO;
import br.com.dev.DesafioItau.service.iservice.TransacaoService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody @Valid TransacaoDTO entity) {

        transacaoService.salvarTransacao(entity);

        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }
    
}
