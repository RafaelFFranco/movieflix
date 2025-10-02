package dev.movieflix.movieflix.Response;

// LOMBOK + RECORD

import lombok.Builder;

// DTO de saída bem estruturado
// Record garante imutabilidade, é bom para responses
@Builder
public record CategoriaResponse(Long id, String nome) {
}
