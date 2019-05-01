package br.edu.utfpr.pb.aula2.repository;

import br.edu.utfpr.pb.aula2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeLikeOrderByNomeDesc (String nome);

    List<Produto> findByDescricaoContaining(String descricao);

    List<Produto> findByValorGreaterThanEqual(Double valor);

    @Query(value = "SELECT p FROM Produto p WHERE p.valor > :valor order by Nome", nativeQuery = false)
    List<Produto> findByValorMaior(@Param("valor") Double valor);

    List<Produto> findByCategoriaDescricaoAndValorLessThanOrderByDataLancamento(String descricao, Double valor);

    List<Produto> findByDataLancamentoBetween(LocalDate dataIni, LocalDate dataFim);
}
