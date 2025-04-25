package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Mapper.StreamingMapper;
import dev.movieflix.movieflix.Model.StreamingModel;
import dev.movieflix.movieflix.Repository.StreamingRepository;
import dev.movieflix.movieflix.Request.StreamingRequest;
import dev.movieflix.movieflix.Response.StreamingResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;
    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    //findAll
    public List<StreamingResponse> listarStreamings(){
       List<StreamingModel> streamings = streamingRepository.findAll();

        return streamings.stream()
               .map(streamingModel -> StreamingMapper.toStreamingResponse(streamingModel))
               .toList();
    }

    //getById
    public StreamingResponse buscarStreamingPorId(Long id){
        Optional<StreamingModel> streamingModel = streamingRepository.findById(id);
        if(streamingModel.isPresent()){
            return StreamingMapper.toStreamingResponse(streamingModel.get());
        }
        return null;
    }

    //Add
    public StreamingResponse inserirStreaming (StreamingRequest streamingRequest){
        StreamingModel streamingModel = StreamingMapper.toStreamingModel(streamingRequest);
        streamingRepository.save(streamingModel);
        return StreamingMapper.toStreamingResponse(streamingModel);
    }

    //Delete
    public void deletarStreaming(Long id){
        Optional<StreamingModel> streamingModel = streamingRepository.findById(id);
        if(streamingModel.isPresent()){
            streamingRepository.deleteById(id);
        }else {
            System.out.println("Não foi possivel deletar o streaming");
        }
    }
}
