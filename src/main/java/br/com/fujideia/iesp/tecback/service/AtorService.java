package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Ator;
import br.com.fujideia.iesp.tecback.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public Ator salvar(Ator ator) {
        return atorRepository.save(ator);
    }

    public Ator buscarPorId(Long id) {
        return atorRepository.findById(id).orElse(null);
    }

    public List<Ator> listarTodos() {
        return atorRepository.findAll();
    }

    public Ator atualizar(Ator ator) {
        return atorRepository.save(ator);
    }

    public void deletar(Long id) {
        atorRepository.deleteById(id);
    }
}
