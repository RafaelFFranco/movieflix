package dev.movieflix.movieflix.Response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String nome) {
}
