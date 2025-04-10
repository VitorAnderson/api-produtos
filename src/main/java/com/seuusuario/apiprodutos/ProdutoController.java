package com.seuusuario.apiprodutos;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
        produtos.add(new Produto(1L, "Mouse Gamer", 150.00));
        produtos.add(new Produto(2L, "Teclado Mecânico", 250.00));
        produtos.add(new Produto(3L, "Monitor 144Hz", 1200.00));
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                produtos.remove(p);
                return "Produto removido com sucesso!";
            }
        }
        return "Produto não encontrado!";
    }

    @PutMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                p.setNome(produtoAtualizado.getNome());
                p.setPreco(produtoAtualizado.getPreco());
                return "Produto atualizado com sucesso!";
            }
        }
        return "Produto não encontrado!";
    }
}
