package br.edu.utfpr.pb.aula2.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name ="produto")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100)
    private String nome;


    @Column(length = 100)
    private String descricao;

    private Double valor;

    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn (name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;
}
