package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Secao;
import br.com.fujideia.iesp.tecback.repository.SecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecaoService {

    private final SecaoRepository secaoRepository;

    public List<Secao> listarTodas() {
        return secaoRepository.findAll();
    }

    public Optional<Secao> buscarPorId(Long id) {
        return secaoRepository.findById(id);
    }

    public List<Secao> buscarPorIntervalo(LocalDateTime start, LocalDateTime end) {
        return secaoRepository.findSecoesByInterval(start, end);
    }

    public Secao criarSecao(Secao secao) {
        return secaoRepository.save(secao);
    }

    public Optional<Secao> atualizarSecao(Long id, Secao secao) {
        return secaoRepository.findById(id)
                .map(existingSecao -> {
                    existingSecao.setDataHora(secao.getDataHora());
                    existingSecao.setFilme(secao.getFilme());
                    existingSecao.setAssentosDisponiveis(secao.getAssentosDisponiveis());
                    return secaoRepository.save(existingSecao);
                });
    }

    public boolean deletarSecao(Long id) {
        return secaoRepository.findById(id)
                .map(secao -> {
                    secaoRepository.delete(secao);
                    return true;
                })
                .orElse(false);
    }
}
