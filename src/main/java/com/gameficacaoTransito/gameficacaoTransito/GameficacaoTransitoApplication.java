package com.gameficacaoTransito.gameficacaoTransito;

import com.gameficacaoTransito.gameficacaoTransito.models.Infracao;
import com.gameficacaoTransito.gameficacaoTransito.models.InfracaoUsuario;
import com.gameficacaoTransito.gameficacaoTransito.models.Usuario;
import com.gameficacaoTransito.gameficacaoTransito.models.Veiculo;
import com.gameficacaoTransito.gameficacaoTransito.services.InfracaoService;
import com.gameficacaoTransito.gameficacaoTransito.services.InfracaoUsuarioService;
import com.gameficacaoTransito.gameficacaoTransito.services.UsuarioService;
import com.gameficacaoTransito.gameficacaoTransito.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GameficacaoTransitoApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService userService;

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private InfracaoService infracaoService;

	@Autowired
	private InfracaoUsuarioService infracaoUsuarioService;

	public static void main(String[] args) {
		SpringApplication.run(GameficacaoTransitoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Usuario usuario = new Usuario("Elton", "elton@iftm.edu.br", "12345678", "A, B");
		userService.insert(usuario);
		usuario.setId(1);

		Veiculo veiculo = new Veiculo("Fiesta","ABC1234","12345678", usuario);
		veiculoService.insert(veiculo);
		veiculo.setId(1);

		Infracao infracao = new Infracao("Excesso de Velocidade", 7);
		infracaoService.insert(infracao);
		infracao.setId(1);
	}
}

/* SEMPRE REALIZAR ESSE INSERT PARA MAIOR CONTROLE DE INFRACOES
{
	"usuario":{
		"id": 1,
        "nome": "Elton",
        "email": "elton@iftm.edu.br",
        "cnh": "12345678",
        "categoria": "A, B"
	},
	"infracao":{
		"id":1,
		"nome":"teste",
		"pontuacao": 3
	},
	"veiculo":{
		"id": 1,
		"modelo":"fiestaasd",
		"placa":"ABC1234",
		"renavam":"12345678"
	}
}
* */
