package br.com.dev.DesafioItau.domain.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoDTO {

    @NotNull(message = "O valor é obrigatório")
    @PositiveOrZero(message = "O valor deve ser zero ou maior que zero")
    private BigDecimal valor;

    @NotNull(message = "A dataHora é obrigatória")
    private OffsetDateTime dataHora;

}
