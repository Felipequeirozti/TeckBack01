package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Secao;
import br.com.fujideia.iesp.tecback.service.SecaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secoes")
@RequiredArgsConstructor
@Slf4j
public class SecaoController {
    private final SecaoService secaoService;

    @GetMapping
    public ResponseEntity<List<Secao>> listarTodas() {
        log.info("Chamando listarTodas no SecaoController");
        List<Secao> secoes = secaoService.listarTodas();
        return ResponseEntity.ok(secoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secao> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no SecaoController com id: {}", id);
        Optional<Secao> secao = secaoService.buscarPorId(id);
        return secao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/intervalo")
    public ResponseEntity<List<Secao>> buscarPorIntervalo(
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end) {
        log.info("Chamando buscarPorIntervalo no SecaoController com intervalo: {} - {}", start, end);
        List<Secao> secoes = secaoService.buscarPorIntervalo(start, end);
        return ResponseEntity.ok(secoes);
    }

    @PostMapping
    public ResponseEntity<Secao> criarSecao(@RequestBody Secao secao) {
        log.info("Chamando criarSecao no SecaoController com dados: {}", secao);
        Secao secaoCriada = secaoService.criarSecao(secao);
        return ResponseEntity.ok(secaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Secao> atualizarSecao(@PathVariable Long id, @RequestBody Secao secao) {
        log.info("Chamando atualizarSecao no SecaoController com id: {} e dados: {}", id, secao);
        Optional<Secao> secaoAtualizada = secaoService.atualizarSecao(id, secao);
        return secaoAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSecao(@PathVariable Long id) {
        log.info("Chamando deletarSecao no SecaoController com id: {}", id);
        boolean deletado = secaoService.deletarSecao(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
