package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SecaoRepository extends JpaRepository<Secao, Long> {

    @Query("SELECT s FROM Secao s WHERE s.dataHora BETWEEN :start AND :end")
    List<Secao> findSecoesByInterval(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("SELECT s FROM Secao s WHERE s.filme.id = :filmeId")
    List<Secao> findSecoesByFilmeId(@Param("filmeId") Long filmeId);
}
