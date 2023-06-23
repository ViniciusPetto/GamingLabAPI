package com.example.demoGamingLab.controller;

import com.example.demoGamingLab.model.Produto;
import com.example.demoGamingLab.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/apiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository prRepo;

    // MODIFICAÇÕES NO BANCO
    @PostMapping("/cadastrar")
    public void cadastrarProduto(@RequestBody Produto pr) {
        prRepo.save(pr);
    }

    @DeleteMapping("/excluir")
    public void excluirProduto(@RequestBody Produto pr) {
        prRepo.delete(pr);
    }

    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody Produto pr) {
        prRepo.save(pr);
    }

    // BUSCA
    @GetMapping("/porCod/{codigo}")
    public Optional<Produto> buscarPorCodigo(@PathVariable(value = "codigo") int codigo) {
        return prRepo.findById(codigo);
    }

    @GetMapping("/porTitulo/{titulo}")
    public List<Produto> buscarPorTitulo(@PathVariable(value = "titulo") String titulo) {
        return prRepo.findByTitulo(titulo);
    }

    @GetMapping("/porDesenvolvedor/{desenvolvedor}")
    public List<Produto> buscarPorDesenvolvedora(@PathVariable(value = "desenvolvedor") String desenvolvedor) {
        return prRepo.findByDesenvolvedora(desenvolvedor);
    }

    @GetMapping("/porPreco/{preco}")
    public List<Produto> buscarPorPreco(@PathVariable(value = "preco") float preco) {
        return prRepo.findByPreco(preco);
    }

    @GetMapping("/porInicial/{titulo}")
    public List<Produto> buscarInicial(@PathVariable(value = "titulo") String titulo) {
        return prRepo.findByInicial(titulo);
    }

    @GetMapping("/precoMaior/{preco}")
    public List<Produto> buscarPrecoMaior(@PathVariable(value = "preco") float preco) {
        return prRepo.findByPrecoMaior(preco);
    }

    @GetMapping("/precoMenor/{preco}")
    public List<Produto> buscarPrecoMenor(@PathVariable(value = "preco") float preco) {
        return prRepo.findByPrecoMenor(preco);
    }

    @GetMapping("/porInicialDev/{desenvolvedora}")
    public List<Produto> buscarInicialDesenvolvedor(@PathVariable(value = "desenvolvedora") String desenvolvedora) {
        return prRepo.findByInicialDesenvolvedor(desenvolvedora);
    }

    @GetMapping("/porIniciais/{titulo}/{desenvolvedora}")
    public List<Produto> buscarIniciais(@PathVariable(value = "titulo") String titulo, @PathVariable(value = "desenvolvedora") String desenvolvedora) {
        return prRepo.findByIniciaisDevTit(titulo, desenvolvedora);
    }

    @GetMapping("/porTituloPreco/{titulo}/{preco}")
    public List<Produto> buscarTituloPreco(@PathVariable(value = "titulo") String titulo, @PathVariable(value = "preco") float preco) {
        return prRepo.findByTituloPreco(titulo, preco);
    }
}

