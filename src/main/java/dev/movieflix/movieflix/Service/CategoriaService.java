package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Model.CategoriaModel;
import dev.movieflix.movieflix.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    public List<CategoriaModel> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel buscarCategoriaPorId(Long id) {
        Optional<CategoriaModel> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.orElse(null);
    }

    public void deleteCategoria(Long id) {
        Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.delete(categoria.get());
        }
    }

    public CategoriaModel addCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

}
