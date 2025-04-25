package dev.movieflix.movieflix.Response;

import lombok.Builder;

@Builder
public record CategoriaResponse(Long id, String nome) {
}
