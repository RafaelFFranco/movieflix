package dev.movieflix.movieflix.Repository;

import dev.movieflix.movieflix.Model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel,Long> {
}
