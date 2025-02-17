package dev.movieflix.movieflix.Mapper;

import dev.movieflix.movieflix.Model.FilmeModel;
import dev.movieflix.movieflix.Request.FilmeRequest;
import dev.movieflix.movieflix.Response.FilmeResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FilmeMapper {
    public FilmeModel toFilmeModel(FilmeRequest filmeRequest) {
        return FilmeModel
                .builder()
                .titulo(filmeRequest.titulo())
                .descricao(filmeRequest.descricao())
                .dataLancamento(filmeRequest.dataLancamento())
                .nota(filmeRequest.nota())
                .build();
    }

    public FilmeResponse toFilmeResponse(FilmeModel filmeModel) {
        return FilmeResponse
                .builder()
                .id(filmeModel.getId())
                .titulo(filmeModel.getTitulo())
                .descricao(filmeModel.getDescricao())
                .dataLancamento(filmeModel.getDataLancamento())
                .nota(filmeModel.getNota())
                .dataCriacao(filmeModel.getDataCriacao())
                .dataAtualizacao(filmeModel.getDataAtualizacao())
                .build();
    }
}
