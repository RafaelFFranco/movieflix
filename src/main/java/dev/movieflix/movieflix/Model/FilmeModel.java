package dev.movieflix.movieflix.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "filmes_tb")
public class FilmeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    private String descricao;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    private double nota;

    //atualiza data de cadastro dos filmes automaticamente
    @Column(name = "data_criacao")
    @UpdateTimestamp
    private LocalDateTime dataCriacao;

    //atualiza data de atualização dos filmes automaticamente
    @Column(name = "data_atualizacao")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    //cria a tabela de relacionamento N para N e faz referencia para o id de filme e o id de categoria
    @ManyToMany
    @JoinTable(name = "filme_categoria",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriaModel> categorias;

    //cria a tabela de relacionamento N para N e faz referencia para o id de filme e o id de streaming
    @ManyToMany
    @JoinTable(name = "filme_streaming",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "streaming_id")
    )
    private List<StreamingModel> streamings;
}
