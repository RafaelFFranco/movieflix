package dev.movieflix.movieflix.Response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record FilmeResponse(Long id,
                            String titulo,
                            String descricao,
                            LocalDate dataLancamento,
                            double nota,
                            LocalDateTime dataCriacao,
                            LocalDateTime dataAtualizacao,
                            List<CategoriaResponse> categorias,
                            List<StreamingResponse> streamings) {
}
