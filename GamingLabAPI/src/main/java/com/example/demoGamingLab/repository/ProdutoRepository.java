package com.example.demoGamingLab.repository;

import com.example.demoGamingLab.model.Cliente;
import com.example.demoGamingLab.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public List<Produto> findByTitulo(String titulo);


    public List<Produto> findByDesenvolvedora (String desenvolvedora);


    @Query (value="select a from Produto a where round (a.preco,2) = ?1")
    public List<Produto> findByPreco (float preco);

    @Query(value="select a from Produto a where a.titulo like ?1%")
    public List<Produto> findByInicial (String titulo);

    @Query (value="select a from Produto a where round (a.preco,2) > ?1")
    public List<Produto> findByPrecoMaior (float preco);

    @Query (value="select a from Produto a where round (a.preco,2) < ?1")
    public List<Produto> findByPrecoMenor (float preco);

    @Query (value="select a from Produto a where a.desenvolvedora like ?1%")
    public List<Produto> findByInicialDesenvolvedor (String desenvolvedora);

    @Query (value="select a from Produto a where a.titulo like ?1% and a.desenvolvedora like ?2%")
    public List<Produto> findByIniciaisDevTit (String titulo, String desenvolvedora);

    @Query (value="select a from Produto a where a.titulo like ?1% and a.preco < ?2")
    public List<Produto> findByTituloPreco (String titulo, float preco);
}
