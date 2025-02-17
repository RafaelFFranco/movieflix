package dev.movieflix.movieflix.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "filmes_tb")
public class FilmeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    private String descricao;

    @ManyToMany
    @JoinTable(name = "filme_categoria",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriaModel> categorias;

    @ManyToMany
    @JoinTable(name = "filme_streaming",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "streaming_id")
    )
    private List<StreamingModel> streamings;
}
