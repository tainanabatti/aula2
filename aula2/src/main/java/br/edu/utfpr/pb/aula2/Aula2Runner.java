package br.edu.utfpr.pb.aula2;

import java.time.LocalDate;
import java.util.Optional;

import br.edu.utfpr.pb.aula2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.utfpr.pb.aula2.model.Categoria;
import br.edu.utfpr.pb.aula2.repository.CategoriaRepository;

@SpringBootApplication
public class Aula2Runner implements CommandLineRunner{

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Aula2Runner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cadastrarCategoria();
        atualizarCategoria();
        listarTodasCategorias();
        listarTodasCategoriasDescricaoLike();
        listarProdutosNomeLike();
        listarProdutosDataLancamentoBetween();


    }

    private void cadastrarCategoria() {
        Categoria c1 = new Categoria();
        c1.setDescricao("Teste");

        categoriaRepository.save(c1);
    }

    private void atualizarCategoria() {
        //Listar 1 registro
        Optional<Categoria> c =
                categoriaRepository.findById(1L);

        c.ifPresent(categoria ->
                System.out.println(categoria));
        Categoria categoria = c.get();
        categoria.setDescricao("Nova descrição");
        categoriaRepository.save(categoria);

        //Retornar uma categoria com .orElse, retorna a categoria do banco
        //no caso de null, retorna uma nova categoria
        Categoria cRetorno = categoriaRepository.findById(5L).orElse(new Categoria());
        System.out.println("Retorno orelse: " + cRetorno);
    }

    private void listarTodasCategorias() {
        //Listar todos
        categoriaRepository.findAll().forEach(
                categoria -> System.out.println(categoria)
        );
    }


    private void listarTodasCategoriasDescricaoLike() {
        categoriaRepository.findByDescricaoLike("%t%")
                .forEach(
                        categoria -> System.out.println(categoria)
                );
    }

    private void listarProdutosNomeLike(){
        produtoRepository.findByNomeLikeOrderByNomeDesc("%te%").forEach(produto -> System.out.println(produto));
    }

    private void listarProdutosDataLancamentoBetween(){
        produtoRepository.findByDataLancamentoBetween(LocalDate.of(2010,1,1),
                LocalDate.of(2015,12,31)).forEach(produto -> System.out.println(produto));
    }
}