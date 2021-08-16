package br.com.fiap.livraria.service;

import java.util.List;

import br.com.fiap.livraria.DTO.LivroDTO;
import br.com.fiap.livraria.DTO.NovoLivroDTO;
import br.com.fiap.livraria.DTO.NovoPrecoDTO;

public interface LivrariaService {

	List<LivroDTO> listarLivros(String titulo);
	
	LivroDTO buscarLivroPorId(Long id);
	
	LivroDTO criar(NovoLivroDTO novoLivroDTO);
	
	LivroDTO atualizar(Long id,NovoLivroDTO novoLivroDTO);
	
	LivroDTO atualizarPreco(Long id, NovoPrecoDTO novoPrecoDTO);
	
	void deletarLivro(Long id);
	
}
