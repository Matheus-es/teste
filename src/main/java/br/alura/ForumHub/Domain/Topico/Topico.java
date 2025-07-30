package br.alura.ForumHub.Domain.Topico;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(unique = true )
    private String titulo;
    @Column(unique = true )
    private String mensagem;
    private String autor;
    private String curso;
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    public Topico(@Valid DadosCadastroTopico dados) {

        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.dataDeCriacao = getDataDeCriacao();


    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {

        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
    }
}
