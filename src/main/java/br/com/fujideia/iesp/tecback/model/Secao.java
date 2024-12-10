package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Secao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ElementCollection
    @CollectionTable(name = "assentos", joinColumns = @JoinColumn(name = "secao_id"))
    @Column(name = "assento")
    private List<String> assentosDisponiveis;
}
