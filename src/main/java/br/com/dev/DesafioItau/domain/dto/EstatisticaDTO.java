package br.com.dev.DesafioItau.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstatisticaDTO {

    private int count;
    private double sum;
    private double avg;
    private double min;
    private double max;

}
