package com.example.demoGamingLab.controller;

import com.example.demoGamingLab.model.Cliente;
import com.example.demoGamingLab.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository clRepo;

    // MODIFICAÇÕES NO BANCO
    @PostMapping ("/cadastrar")
    public void cadastrarCliente (@RequestBody Cliente cl)
    {
        clRepo.save(cl);
    }

    @DeleteMapping ("/excluir")
    public void excluirCliente (@RequestBody Cliente cl)
    {
       clRepo.delete(cl);
    }

    @PutMapping ("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cl)
    {
        clRepo.save(cl);
    }

    // BUSCA
    @GetMapping("/porCod/{codigo}")
    public Optional<Cliente> buscarPorCodigo(@PathVariable(value = "codigo") int codigo) {
        return clRepo.findById(codigo);
    }

    @GetMapping("/porNome/{nome}")
    public List<Cliente> buscarPorNome(@PathVariable(value = "nome") String nome) {
        return clRepo.findByNome(nome);
    }

    @GetMapping("/porEmail/{email}")
    public List<Cliente> buscarPorEmail(@PathVariable(value = "email") String email) {
        return clRepo.findByEmail(email);
    }

    @GetMapping("/porInicial/{nome}")
    public List<Cliente> buscarInicial(@PathVariable(value = "nome") String nome) {
        return clRepo.findByInicial(nome);
    }

    @GetMapping("/codMaior/{codigo}")
    public List<Cliente> buscarCodMaior(@PathVariable(value = "codigo") int codigo) {
        return clRepo.findByCodMaior(codigo);
    }

    @GetMapping("/porInicialEmail/{email}")
    public List<Cliente> buscarInicialEmail(@PathVariable(value = "email") String email) {
        return clRepo.findByInicialEmail(email);
    }

    @GetMapping("/porIniciais/{email}/{nome}")
    public List<Cliente> buscarIniciais(@PathVariable(value = "email") String email, @PathVariable(value = "nome") String nome) {
        return clRepo.findByIniciais(email,nome);
    }
}