package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Repository.FilmeRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }
}
