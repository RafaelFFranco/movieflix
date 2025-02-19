package dev.movieflix.movieflix.Controller;

import dev.movieflix.movieflix.Request.FilmeRequest;
import dev.movieflix.movieflix.Response.FilmeResponse;
import dev.movieflix.movieflix.Service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    //buscar filmes
    @GetMapping
    public ResponseEntity<List<FilmeResponse>> listarFilmes(){
        return ResponseEntity.ok(filmeService.listarFilmes());
    }

    //buscar filme por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFilme(@PathVariable Long id){
        Optional<FilmeResponse> filme = filmeService.buscarFilme(id);
        if(filme.isPresent()){
            return ResponseEntity.ok(filme.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
    }

    //salvar novo filme
    @PostMapping("/add")
    public ResponseEntity<FilmeResponse> salvarFilme(@RequestBody FilmeRequest filme){
        return ResponseEntity.ok(filmeService.salvarFilme(filme));
    }

    //deleta filme existente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarFilme(@PathVariable Long id) {
        Optional<FilmeResponse> filme = filmeService.buscarFilme(id);
        if(filme.isPresent()){
            filmeService.deletarFilme(id);
           return ResponseEntity.status(HttpStatus.OK).body("Filme deletado com sucesso");
        }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
    }

}
