package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Ator;
import br.com.fujideia.iesp.tecback.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    public ResponseEntity<Ator> criarAtor(@RequestBody Ator ator) {
        Ator novoAtor = atorService.salvar(ator);
        return ResponseEntity.ok(novoAtor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ator> buscarAtorPorId(@PathVariable Long id) {
        Ator ator = atorService.buscarPorId(id);
        return ResponseEntity.ok(ator);
    }

    @GetMapping
    public ResponseEntity<List<Ator>> listarTodosAtores() {
        List<Ator> atores = atorService.listarTodos();
        return ResponseEntity.ok(atores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ator> atualizarAtor(@PathVariable Long id, @RequestBody Ator ator) {
        ator.setId(id);
        Ator atorAtualizado = atorService.atualizar(ator);
        return ResponseEntity.ok(atorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtor(@PathVariable Long id) {
        atorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
