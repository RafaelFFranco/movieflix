package dev.movieflix.movieflix.Request;

import java.time.LocalDate;
import java.util.List;

public record FilmeRequest(String titulo,
                           String descricao,
                           LocalDate dataLancamento,
                           double nota,
                           List<Long> categorias,
                           List<Long> streamings) {
}
