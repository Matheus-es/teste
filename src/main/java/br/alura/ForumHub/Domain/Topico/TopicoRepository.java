package br.alura.ForumHub.Domain.Topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAll(Pageable paginacao);
    Optional<Topico> findByAutorAndTitulo(String mensagem, String titulo);
}
