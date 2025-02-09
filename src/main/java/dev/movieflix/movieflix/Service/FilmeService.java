package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Model.FilmeModel;
import dev.movieflix.movieflix.Repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }


    public List<FilmeModel> listarFilmes(){
        return filmeRepository.findAll();
    }
}
