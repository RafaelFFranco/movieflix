package dev.movieflix.movieflix.Repository;

import dev.movieflix.movieflix.Model.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<FilmeModel,Long> {
}
