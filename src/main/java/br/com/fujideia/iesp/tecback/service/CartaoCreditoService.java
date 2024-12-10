package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;
import br.com.fujideia.iesp.tecback.repository.CartaoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoCreditoService {

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    public CartaoCredito salvar(CartaoCredito cartaoCredito) {
        return cartaoCreditoRepository.save(cartaoCredito);
    }

    public CartaoCredito buscarPorId(Long id) {
        return cartaoCreditoRepository.findById(id).orElse(null);
    }

    public List<CartaoCredito> listarTodos() {
        return cartaoCreditoRepository.findAll();
    }

    public CartaoCredito atualizar(CartaoCredito cartaoCredito) {
        return cartaoCreditoRepository.save(cartaoCredito);
    }

    public void deletar(Long id) {
        cartaoCreditoRepository.deleteById(id);
    }
}
