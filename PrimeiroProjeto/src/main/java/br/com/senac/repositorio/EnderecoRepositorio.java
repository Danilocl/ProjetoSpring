package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.dominio.Endereco;
import br.com.senac.dominio.Estado;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer>{

}
