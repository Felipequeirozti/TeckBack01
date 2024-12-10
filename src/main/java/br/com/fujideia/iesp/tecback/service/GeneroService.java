package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public Genero salvar(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero buscarPorId(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    public Genero atualizar(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deletar(Long id) {
        generoRepository.deleteById(id);
    }
}
