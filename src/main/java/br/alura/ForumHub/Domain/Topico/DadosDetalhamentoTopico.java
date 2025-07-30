package br.alura.ForumHub.Domain.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(long id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        LocalDateTime dataDeCriacao) {

    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensagem(),topico.getAutor(), topico.getCurso(),topico.getDataDeCriacao());
    }
}
