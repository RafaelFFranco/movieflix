package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Model.CategoriaModel;
import dev.movieflix.movieflix.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Camada de serviço bem definida

@Service
public class CategoriaService {

    //  Constructor injection é a uma boa prática
    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    // Considerar paginação se a lista crescer muito
    public List<CategoriaModel> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel buscarCategoriaPorId(Long id) {
        Optional<CategoriaModel> optionalCategoria = categoriaRepository.findById(id);
        //  Problema de design: Retorno null é um anti-pattern
        // O uso de .orElse(null) quebra o princípio "fail-fast" e pode causar NullPointerException em runtime.
        // Problemas identificados:
        // • Clientes precisam sempre verificar null
        // • Possíveis NPE em runtime
        // • Inconsistência com outros métodos que usam Optional
        //  Sugestão: Alterar retorno para Optional<CategoriaModel> ou lançar EntityNotFoundException
        return optionalCategoria.orElse(null);
    }

    public void deleteCategoria(Long id) {
        Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);
        }
    }

    public CategoriaModel addCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

}
