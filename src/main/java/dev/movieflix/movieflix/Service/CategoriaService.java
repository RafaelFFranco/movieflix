package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }



}
