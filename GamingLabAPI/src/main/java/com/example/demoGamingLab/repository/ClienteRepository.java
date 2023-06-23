package com.example.demoGamingLab.repository;

import com.example.demoGamingLab.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public List<Cliente> findByNome(String nome);


    public List<Cliente> findByEmail (String email);



    @Query (value="select a from Cliente a where a.nome like ?1%")
    public List<Cliente> findByInicial (String nome);

    @Query (value="select a from Cliente a where a.codigo > ?1")
    public List<Cliente> findByCodMaior (int codigo);

    @Query (value="select a from Cliente a where a.email like ?1%")
    public List<Cliente> findByInicialEmail (String email);

    @Query (value="select a from Cliente a where a.email like ?1% and a.nome like ?2%")
    public List<Cliente> findByIniciais (String email, String nome);

}
