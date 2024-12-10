package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<Genero> criarGenero(@RequestBody Genero genero) {
        Genero novoGenero = generoService.salvar(genero);
        return ResponseEntity.ok(novoGenero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarGeneroPorId(@PathVariable Long id) {
        Genero genero = generoService.buscarPorId(id);
        return ResponseEntity.ok(genero);
    }

    @GetMapping
    public ResponseEntity<List<Genero>> listarTodosGeneros() {
        List<Genero> generos = generoService.listarTodos();
        return ResponseEntity.ok(generos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> atualizarGenero(@PathVariable Long id, @RequestBody Genero genero) {
        genero.setId(id);
        Genero generoAtualizado = generoService.atualizar(genero);
        return ResponseEntity.ok(generoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGenero(@PathVariable Long id) {
        generoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
