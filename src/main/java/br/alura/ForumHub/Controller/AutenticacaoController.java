package br.alura.ForumHub.Controller;

import br.alura.ForumHub.Domain.Usuario.DadosAutenticacao;
import br.alura.ForumHub.Domain.Usuario.DadosCadastroUsuario;
import br.alura.ForumHub.Domain.Usuario.Usuario;
import br.alura.ForumHub.Domain.Usuario.UsuarioRepository;
import br.alura.ForumHub.infra.security.DadosTokenJWT;
import br.alura.ForumHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping("logar")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {

        System.out.println("Login recebido: " + dados.login());
        System.out.println("Senha recebida: " + dados.senha());

        var usuario = new Usuario(dados.login(), encoder.encode(dados.senha()));
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }

}


