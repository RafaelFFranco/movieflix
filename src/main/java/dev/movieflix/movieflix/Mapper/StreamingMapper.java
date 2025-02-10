package dev.movieflix.movieflix.Mapper;

import dev.movieflix.movieflix.Model.StreamingModel;
import dev.movieflix.movieflix.Request.StreamingRequest;
import dev.movieflix.movieflix.Response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    //static para ser acessado somento por importar a classe
    //recebe StreamingRequest e transforma em StreamingModel
    public static StreamingModel toStreamingModel(StreamingRequest streamingModel) {
       return StreamingModel
                .builder()
                .nome(streamingModel.nome())
                .build();
    }

    public static StreamingResponse toStreamingResponse(StreamingModel streamingModel) {
        return StreamingResponse
                .builder()
                .id(streamingModel.getId())
                .nome(streamingModel.getNome())
                .build();
    }
}
