package dev.movieflix.movieflix.Mapper;

import dev.movieflix.movieflix.Model.CategoriaModel;
import dev.movieflix.movieflix.Model.FilmeModel;
import dev.movieflix.movieflix.Model.StreamingModel;
import dev.movieflix.movieflix.Request.FilmeRequest;
import dev.movieflix.movieflix.Response.CategoriaResponse;
import dev.movieflix.movieflix.Response.FilmeResponse;
import dev.movieflix.movieflix.Response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FilmeMapper {
    public static FilmeModel toFilmeModel(FilmeRequest filmeRequest) {

        //recebo a lista de long das categorias e trasnformo em CategoriaModel para criar o FilmeModel que recebe uma lista de CategoriaModel
        List<CategoriaModel> categorias = filmeRequest.categorias().stream()
                .map(categoriaId -> CategoriaModel.builder().id(categoriaId).build())
                .toList();

        //recebo a lista de long dos streamings e transformo em StreamingModel para criar o FilmeModel que recebe uma lista de StreamingModel
        List<StreamingModel> streamings = filmeRequest.streamings().stream()
                .map(streamingId -> StreamingModel.builder().id(streamingId).build())
                .toList();

        return FilmeModel
                .builder()
                .titulo(filmeRequest.titulo())
                .descricao(filmeRequest.descricao())
                .dataLancamento(filmeRequest.dataLancamento())
                .nota(filmeRequest.nota())
                .categorias(categorias)
                .streamings(streamings)
                .build();
    }

    public static FilmeResponse toFilmeResponse(FilmeModel filmeModel) {

        List<CategoriaResponse> categorias = filmeModel.getCategorias().stream()
                .map(categoriaModel -> CategoriaMapper.toCategoriaResponse(categoriaModel))
                .toList();

        List<StreamingResponse> streamings = filmeModel.getStreamings().stream()
                .map(streamingModel -> StreamingMapper.toStreamingResponse(streamingModel))
                .toList();

        return FilmeResponse
                .builder()
                .id(filmeModel.getId())
                .titulo(filmeModel.getTitulo())
                .descricao(filmeModel.getDescricao())
                .dataLancamento(filmeModel.getDataLancamento())
                .nota(filmeModel.getNota())
                .dataCriacao(filmeModel.getDataCriacao())
                .dataAtualizacao(filmeModel.getDataAtualizacao())
                .categorias(categorias)
                .streamings(streamings)
                .build();
    }
}
