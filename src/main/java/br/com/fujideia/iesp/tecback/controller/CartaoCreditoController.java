package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;
import br.com.fujideia.iesp.tecback.service.CartaoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoCreditoController {

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @PostMapping
    public ResponseEntity<CartaoCredito> criarCartao(@RequestBody CartaoCredito cartaoCredito) {
        CartaoCredito novoCartao = cartaoCreditoService.salvar(cartaoCredito);
        return ResponseEntity.ok(novoCartao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaoCredito> buscarCartaoPorId(@PathVariable Long id) {
        CartaoCredito cartaoCredito = cartaoCreditoService.buscarPorId(id);
        return ResponseEntity.ok(cartaoCredito);
    }

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> listarTodosCartoes() {
        List<CartaoCredito> cartoes = cartaoCreditoService.listarTodos();
        return ResponseEntity.ok(cartoes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaoCredito> atualizarCartao(@PathVariable Long id, @RequestBody CartaoCredito cartaoCredito) {
        cartaoCredito.setId(id);
        CartaoCredito cartaoAtualizado = cartaoCreditoService.atualizar(cartaoCredito);
        return ResponseEntity.ok(cartaoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCartao(@PathVariable Long id) {
        cartaoCreditoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
