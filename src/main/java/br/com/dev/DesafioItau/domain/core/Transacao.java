package br.com.dev.DesafioItau.domain.core;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao {

    private Long id;
    private Double valor;
    private OffsetDateTime dataHora;

}
