package dev.movieflix.movieflix.Mapper;

import dev.movieflix.movieflix.Model.CategoriaModel;
import dev.movieflix.movieflix.Request.CategoriaRequest;
import dev.movieflix.movieflix.Response.CategoriaResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoriaMapper {

    //recebe um CategoriaRequest e transforma em CategoriaModel
    public static CategoriaModel toCategoria(CategoriaRequest categoriaRequest){
        return CategoriaModel
                .builder()
                .nome(categoriaRequest.nome())
                .build();
    }

    //recebe um CategoriaModel e transforma em um CategoriaResponse
    public static CategoriaResponse toCategoriaResponse(CategoriaModel categoriaModel){
        return CategoriaResponse
                .builder()
                .id(categoriaModel.getId())
                .nome(categoriaModel.getNome())
                .build();
    }
}
