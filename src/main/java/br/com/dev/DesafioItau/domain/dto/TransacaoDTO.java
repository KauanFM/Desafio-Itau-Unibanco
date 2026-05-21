package br.com.dev.DesafioItau.domain.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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

    @NotNull
    @PositiveOrZero
    private Double valor;

    @NotNull
    @PastOrPresent
    private OffsetDateTime dataHora;

}
