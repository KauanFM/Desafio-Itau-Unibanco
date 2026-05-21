package br.com.dev.DesafioItau.domain.core;

import java.math.BigDecimal;
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

    private Integer id;
    private BigDecimal valor;
    private OffsetDateTime dataHora;

}
