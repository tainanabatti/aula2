package br.edu.utfpr.pb.aula2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="categoria")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100)
    private String descricao;



}
