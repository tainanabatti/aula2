package br.edu.utfpr.pb.aula2.repository;

import br.edu.utfpr.pb.aula2.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByDescricaoLike(String descricao);
}
