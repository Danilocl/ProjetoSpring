package br.com.senac.inicializacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Cidade;
import br.com.senac.dominio.Endereco;
import br.com.senac.dominio.Estado;
import br.com.senac.dominio.Pagamento;
import br.com.senac.dominio.PagamentoComBoleto;
import br.com.senac.dominio.Pedido;
import br.com.senac.dominio.enums.StatusPagamento;
import br.com.senac.repositorio.AlunoRepositorio;
import br.com.senac.repositorio.CidadeRepositorio;
import br.com.senac.repositorio.EnderecoRepositorio;
import br.com.senac.repositorio.EstadoRepositorio;
import br.com.senac.repositorio.PagamentoRepositorio;
import br.com.senac.repositorio.PedidoRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoRepositorio alunoRepo;
	@Autowired
	CidadeRepositorio cidadeRepo;
	@Autowired
	EstadoRepositorio estadoRepo;
	@Autowired
	EnderecoRepositorio endereRepo;
	@Autowired
	PedidoRepositorio pedidoRepo;
	@Autowired
	PagamentoRepositorio pagamentoRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		Aluno aluno = new Aluno();
		aluno.setNome("Lucas");
		aluno.setEmail("lucas@gmail.com");

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Lucas");
		aluno2.setEmail("lucas@gmail.com");

<<<<<<< HEAD
		Aluno alunoGravado = alunoRepo.findByEmail("danilocalessa@gmail.com");
		
		
		Estado estado = new Estado();
=======
		Aluno alunoGravado = alunoRepo.findByEmail("lucas@gmail.com");

		Estado estado1 = new Estado();
>>>>>>> 39abc5cd3c4a1925d3083ae906958180c7a168cf
		Estado estado2 = new Estado();
		estado1.setNome("Rio de Janeiro");
		estado2.setNome("São Paulo");

		estadoRepo.saveAll(Arrays.asList(estado1, estado2));

		Cidade cidade1 = new Cidade();
		Cidade cidade2 = new Cidade();
		Cidade cidade3 = new Cidade();
		cidade1.setNome("Angra do Reis");
		cidade2.setNome("Cabo Frio");
		cidade3.setNome("Mogi das Cruzes");
		cidade1.setEstado(estado1);
		cidade2.setEstado(estado1);
		cidade3.setEstado(estado2);

		cidadeRepo.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		Endereco end = new Endereco();
		end.setBairro("Centro");
		end.setCidade(cidade1);
		end.setComplemento("Bloco B");
		end.setNumero("20");
		end.setRua("Rua das Andrades");
		end.setCep("22341-175");
		end.setAluno(aluno);

		aluno.getTelefones().addAll(Arrays.asList("123123123", "123123123"));
		// aluno2.getTelefones().addAll(Arrays.asList("123123123", "123123123"));

		alunoRepo.save(aluno);

		endereRepo.saveAll(Arrays.asList(end));

		Pedido ped1 = new Pedido();
		ped1.setAluno(aluno);
		ped1.setEnderecoDeEntrega(end);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

		try {
			// fez o pedido nesta data
			ped1.setDataPedido(sdf.parse("27/06/2018 09:08"));

			Pagamento pag1 = new PagamentoComBoleto(null, StatusPagamento.QUITADO, ped1, sdf.parse("30/06/2018 00:00"),
					sdf.parse("29/06/2018 00:00"));

			ped1.setPagamento(pag1);

			// salvando o pedido
			pedidoRepo.save(ped1);

			// salvando o pagamento
			pagamentoRepo.save(pag1);

		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
