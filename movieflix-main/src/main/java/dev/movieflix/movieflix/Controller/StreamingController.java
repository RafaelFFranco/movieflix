package dev.movieflix.movieflix.Controller;

import dev.movieflix.movieflix.Request.StreamingRequest;
import dev.movieflix.movieflix.Response.StreamingResponse;
import dev.movieflix.movieflix.Service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/streamings")
public class StreamingController {
    private final StreamingService streamingService;
    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> listarStreamings(){
        return ResponseEntity.ok(streamingService.listarStreamings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarStreamingPorId(@PathVariable Long id){
        StreamingResponse streamingResponse = streamingService.buscarStreamingPorId(id);
        if(streamingResponse != null){
            return ResponseEntity.ok(streamingResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Streaming com id: "+id+" não encontrado");
    }

    @PostMapping("/add")
    public ResponseEntity<StreamingResponse> addStreaming(@RequestBody StreamingRequest streamingRequest){
        return ResponseEntity.ok(streamingService.inserirStreaming(streamingRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStreaming(@PathVariable Long id){
        StreamingResponse streamingResponse = streamingService.buscarStreamingPorId(id);
        if (streamingResponse != null) {
            streamingService.deletarStreaming(id);
            return ResponseEntity.ok("Streaming com id: "+id+" deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Streaming com id: "+id+" não encontrado");
    }
}
