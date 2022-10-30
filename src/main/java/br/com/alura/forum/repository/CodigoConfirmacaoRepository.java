package br.com.alura.forum.repository;

import br.com.alura.forum.controller.Registrar.codigo.CodigoConfirmacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CodigoConfirmacaoRepository extends JpaRepository<CodigoConfirmacao, Long> {
    Optional<CodigoConfirmacao> findByCodigo(String codigo);

    @Transactional
    @Modifying
    @Query("UPDATE CodigoConfirmacao c SET c.confirmedAt = ?2 WHERE c.codigo = ?1")
    int updateConfirmedAt(String codigo, LocalDateTime now);
}
