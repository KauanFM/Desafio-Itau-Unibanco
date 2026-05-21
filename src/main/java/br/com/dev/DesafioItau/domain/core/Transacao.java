package br.com.dev.DesafioItau.domain.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao {

    private Integer id;
    private double valor;
    private String dataHora;

}
