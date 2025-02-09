package dev.movieflix.movieflix.Repository;

import dev.movieflix.movieflix.Model.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<StreamingModel,Long> {
}
