package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {

    @Query("SELECT c FROM CartaoCredito c WHERE c.numero LIKE %:numero%")
    List<CartaoCredito> buscarPorNumero(@Param("numero") String numero);
}
