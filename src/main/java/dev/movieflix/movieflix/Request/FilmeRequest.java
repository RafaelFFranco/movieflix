package dev.movieflix.movieflix.Request;

import java.time.LocalDate;

public record FilmeRequest(String titulo, String descricao, LocalDate dataLancamento, double nota) {
}
