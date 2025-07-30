package br.alura.ForumHub.Domain.Topico;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        long id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        LocalDateTime dataDeCriacao) {

    public DadosListagemTopicos(Topico topico){
        this(topico.getId(), topico.getMensagem(), topico.getTitulo(), topico.getAutor(), topico.getCurso(),topico.getDataDeCriacao());
    }
}
