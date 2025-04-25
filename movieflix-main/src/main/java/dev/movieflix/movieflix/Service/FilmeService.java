package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Mapper.FilmeMapper;
import dev.movieflix.movieflix.Model.FilmeModel;
import dev.movieflix.movieflix.Repository.FilmeRepository;
import dev.movieflix.movieflix.Request.FilmeRequest;
import dev.movieflix.movieflix.Response.FilmeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    //Listar filmes
    public List<FilmeResponse> listarFilmes(){
        List<FilmeModel> filmes = filmeRepository.findAll();
        return filmes.stream()
                .map(filmeModel -> FilmeMapper.toFilmeResponse(filmeModel))
                .toList();
    }

    //Buscar por Id
    public Optional<FilmeResponse> buscarFilme(Long id){
        return filmeRepository.findById(id).map(filmeModel -> FilmeMapper.toFilmeResponse(filmeModel));
    }

    //Salvar novo filme
    public FilmeResponse salvarFilme(FilmeRequest filmeRequest){
        FilmeModel filmeModel = FilmeMapper.toFilmeModel(filmeRequest);
        filmeRepository.save(filmeModel);
        return FilmeMapper.toFilmeResponse(filmeModel);
    }

    //Deletar
    public void deletarFilme(Long id){
        Optional<FilmeModel> filme = filmeRepository.findById(id);
        if(filme.isPresent()){
            filmeRepository.deleteById(id);
        }
    }

    //Editar TO:DO
   /* public FilmeResponse editarFilme(FilmeRequest filmeRequest){
        return
    }*/
}
